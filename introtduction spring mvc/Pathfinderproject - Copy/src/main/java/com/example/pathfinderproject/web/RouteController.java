package com.example.pathfinderproject.web;

import com.example.pathfinderproject.model.binding.CommentCreateBM;
import com.example.pathfinderproject.model.binding.RouteCreateBM;
import com.example.pathfinderproject.model.service.RouteServiceModel;
import com.example.pathfinderproject.service.RouteService;
import com.example.pathfinderproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, UserService userService, ModelMapper modelMapper)
    {
        this.userService = userService;
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute(name = "commentCreateBM")
    public CommentCreateBM commentCreateBM(){
        return new CommentCreateBM();
    }


    @ModelAttribute
    public RouteCreateBM routeCreateBM(){
        return new RouteCreateBM();
    }

    @GetMapping("/add")
    public String addGET(){
        if(!this.userService.isLogged()){
            return "redirect:/users/login";
        }
        return "add-route";
    }


    @PostMapping("/add")
    public String addPOST(@Valid RouteCreateBM routeCreateBM,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) throws IOException {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("routeCreateBM",routeCreateBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routCreateBM", bindingResult);

            return "redirect:add";
        }

        RouteServiceModel routeServiceModel = this.modelMapper.map(routeCreateBM,RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeCreateBM.getGpxCoordinates().getBytes()));
        this.routeService.addNewRoute(routeServiceModel);

        return "redirect:/";
    }

    @GetMapping()
    public String allRoutes(Model model){
        model.addAttribute("routes",this.routeService.findAllRoutesView());
        return "routes";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("route",this.routeService.findRouteById(id));
        model.addAttribute("routeId",id);
        return "route-details";
    }


}
