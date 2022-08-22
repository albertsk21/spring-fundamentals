package bg.softuni.project.linkedout.web;

import bg.softuni.project.linkedout.model.dto.EmployeeDTO;
import bg.softuni.project.linkedout.service.CompanyService;
import bg.softuni.project.linkedout.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private CompanyService companyService;

    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @ModelAttribute
    public EmployeeDTO employeeDTO(){
        return new EmployeeDTO();
    }

    @GetMapping("/add")
    public String addEmployeeGET(Model model){
        model.addAttribute("companies",this.companyService.getAll());
        return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployeePOST(@Valid @ModelAttribute EmployeeDTO employeeDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("employeeDTO",employeeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeDTO",bindingResult);

            return "redirect:/employees/add";
        }

        this.employeeService.save(employeeDTO);
        return "redirect:/employees/all";
    }

    @GetMapping("/all")
    public String allEmployees(Model model){
        model.addAttribute("employees",this.employeeService.getAll());
        return "employee-all";
    }


    @GetMapping("/details/{id}")
    public String employeeDetails(@PathVariable(name = "id") String id, Model model){
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee-details";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") String id){
        this.employeeService.deleteById(id);
        return "redirect:/employees/all";
    }


}
