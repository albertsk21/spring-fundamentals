package bg.softuni.mvc.mvcApplication.web;

import bg.softuni.mvc.mvcApplication.models.dtos.CatDTO;
import bg.softuni.mvc.mvcApplication.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cats")
public class CatController {

    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/new")
    public String newCat(){
        return "new-cat";
    }

    @PostMapping
    public String createCat(CatDTO newCat){
      Long catId  =   this.catService.createCat(newCat);
      return "redirect:/cats/" + catId;
    }

    @GetMapping("/{id}")
    public String getCat(Model model, @PathVariable("id") Long id){
       CatDTO cat  = this.catService.getCatById(id).orElseThrow();
       model.addAttribute("cat",cat);
        return "cat";
    }

    @GetMapping
    public String getAllCats(Model model){
        model.addAttribute("cats",this.catService.getAllCats());
        return "all-cats";
    }

    @DeleteMapping
    public String deleteCat(@RequestParam("cat_id") Long catId){
        this.catService.deleteCat(catId);
        return "redirect:/cats";
    }
}

