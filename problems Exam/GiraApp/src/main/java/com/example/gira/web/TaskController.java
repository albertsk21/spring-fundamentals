package com.example.gira.web;


import com.example.gira.domain.bm.TaskBM;
import com.example.gira.domain.dtos.TaskDTO;
import com.example.gira.domain.enums.ProgressNameEnum;
import com.example.gira.domain.vm.ClassificationVM;
import com.example.gira.domain.vm.TaskVM;
import com.example.gira.services.ClassificationService;
import com.example.gira.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private ModelMapper modelMapper;
    private TaskService taskService;
    private ClassificationService classificationService;

    public TaskController(ModelMapper modelMapper, TaskService taskService, ClassificationService classificationService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
        this.classificationService = classificationService;
    }



    @ModelAttribute("taskModel")
    public TaskBM taskModel(){
        return new TaskBM();
    }

    @GetMapping("")
    public String tasks(HttpSession httpSession,
                        Model model){


        model.addAttribute("tasks",
                this.taskService.getAll()
                        .stream()
                        .map( t -> this.modelMapper.map(t, TaskVM.class))
                        .collect(Collectors.toList()));

        return httpSession.getAttribute("token") == null ? "redirect:/" : "home";
    }

    @GetMapping("/add")
    public String addTaskGET(HttpSession httpSession,
                             Model model){



        model.addAttribute("classifications",
                this.classificationService.getAll()
                        .stream()
                        .map(c -> this.modelMapper.map(c, ClassificationVM.class))
                        .collect(Collectors.toList()));


        return httpSession.getAttribute("token") == null ? "redirect:/" : "add-task";
    }

    @PostMapping("/add")
    public String addTaskPOST(@Valid @ModelAttribute TaskBM taskModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              HttpSession httpSession){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskModel",taskModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskModel",bindingResult);
            return "redirect:/tasks/add";
        }

        UUID id = (UUID) httpSession.getAttribute("token");
        TaskDTO taskDTO =this.modelMapper.map(taskModel,TaskDTO.class);
        this.taskService.saveTask(taskDTO, id);

        return "redirect:/tasks";
    }

    @PostMapping("/{id}")
    public String pressButtonForm(@PathVariable(name = "id") String id, HttpSession httpSession){

        UUID uuid = UUID.fromString(id);
        TaskDTO taskDTO = this.taskService.findById(uuid);

        if(taskDTO.getProgress().name().equals("COMPLETED")){
            this.taskService.deleteById(uuid);

        }else {
            int counter = ProgressNameEnum.indexOf(taskDTO.getProgress().name());
            counter++;

            taskDTO.setProgress(ProgressNameEnum.getValue(counter));
            this.taskService.saveTask(taskDTO, (UUID) httpSession.getAttribute("token"));

        }



        return "redirect:/tasks";
    }

}
