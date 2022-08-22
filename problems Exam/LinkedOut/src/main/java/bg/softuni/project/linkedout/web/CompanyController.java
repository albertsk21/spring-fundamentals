package bg.softuni.project.linkedout.web;

import bg.softuni.project.linkedout.model.dto.CompanyDTO;
import bg.softuni.project.linkedout.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute
    public CompanyDTO companyDTO(){
        return new CompanyDTO();
    }

    @GetMapping("/add")
    public String addCompanyGET(){
        return "company-add";
    }


    @PostMapping("/add")
    public String addCompanyPOST(@Valid @ModelAttribute CompanyDTO companyDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("companyDTO",companyDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyDTO",bindingResult);
            return "redirect:/companies/add";
        }
        this.companyService.save(companyDTO);
        return "redirect:/companies/all";

    }

    @GetMapping("/all")
    public String allCompanies(Model model){
        model.addAttribute("companies",this.companyService.getAll());
        return "company-all";
    }
    @GetMapping("/details/{id}")
    public String companyDetails(@PathVariable(name = "id") String id, Model model){
        model.addAttribute("companyDTO",this.companyService.findById(id));
        return "company-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable(name = "id") String id){
        this.companyService.deleteById(id);
        return "redirect:/companies/all";
    }

}
