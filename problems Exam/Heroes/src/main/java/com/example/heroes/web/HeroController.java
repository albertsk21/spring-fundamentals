package com.example.heroes.web;


import com.example.heroes.model.bm.HeroBM;
import com.example.heroes.model.dtos.HeroDTO;
import com.example.heroes.model.vm.HeroVM;
import com.example.heroes.service.HeroService;
import com.example.heroes.util.RedirectPage;
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
@RequestMapping("/heroes")
public class HeroController {

    private HeroService heroService;
    private ModelMapper modelMapper;


    @ModelAttribute("heroModel")
    public HeroBM heroModel(){
        return new HeroBM();
    }

    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/home")
    public String heroes(Model model, HttpSession httpSession){

        model.addAttribute("heroes",
                this.heroService.getAllByUserId( (UUID) httpSession.getAttribute("token"))
                        .stream()
                        .map(hero -> this.modelMapper.map(hero, HeroBM.class))
                        .collect(Collectors.toList()));

        return RedirectPage.redirectToIndex(httpSession,"home");
    }


    @GetMapping("/create")
    public String createHeroGET(HttpSession httpSession){
        return RedirectPage.redirectToIndex(httpSession,"create-hero");
    }

    @PostMapping("/create")
    public String createHeroPost(@Valid @ModelAttribute("heroModel") HeroBM heroModel,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult bindingResult,
                                 HttpSession httpSession){


        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("heroModel",heroModel);
            return "redirect:/heroes/create";
        }

        HeroDTO heroDTO = this.modelMapper.map(heroModel,HeroDTO.class);
        this.heroService.save(heroDTO,(UUID) httpSession.getAttribute("token"));
        return "redirect:/heroes/home";
    }

    @GetMapping("/details/{id}")
    public String getHero(@PathVariable(name = "id") String id,
                          Model model,
                          HttpSession httpSession){
        model.addAttribute("hero",this.modelMapper.map(this.heroService.getHero(UUID.fromString(id)),HeroBM.class));
        return RedirectPage.redirectToIndex(httpSession,"details-hero");
    }


    @GetMapping("/delete/{id}")
    public String deleteHeroGET(@PathVariable(name = "id") String id,
                             Model model,
                             HttpSession httpSession){
        model.addAttribute("hero",this.modelMapper.map(this.heroService.getHero(UUID.fromString(id)),HeroBM.class));
        return RedirectPage.redirectToIndex(httpSession,"delete-hero");
    }
    @PostMapping("/delete/{id}")
    public String deleteHeroPOST(@PathVariable(name = "id") String id){
        this.heroService.delete(UUID.fromString(id));
        return "redirect:/heroes/home";
    }



}
