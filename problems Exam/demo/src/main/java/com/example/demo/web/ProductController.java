package com.example.demo.web;

import com.example.demo.domain.bm.ItemBM;
import com.example.demo.domain.bm.RegisterBM;
import com.example.demo.domain.dtos.ItemDTO;
import com.example.demo.domain.dtos.UserDTO;
import com.example.demo.domain.vm.CategoryVM;
import com.example.demo.domain.vm.ItemVM;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ItemService;
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
@RequestMapping("/products")
public class ProductController {

    private ModelMapper modelMapper;
    private ItemService itemService;
    private CategoryService categoryService;

    public ProductController(ModelMapper modelMapper, ItemService itemService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.itemService = itemService;
        this.categoryService = categoryService;
    }


    @ModelAttribute(name = "itemModel")
    public ItemBM itemModel(){
        return new ItemBM();
    }


    @GetMapping("")
    public String home(HttpSession httpSession,
                       Model model){

        model.addAttribute("items",
                this.itemService.getAll()
                .stream()
                .map( i -> this.modelMapper.map(i, ItemVM.class))
                .collect(Collectors.toList()));

        return httpSession.getAttribute("token") == null ? "redirect:/" : "home";
    }

    @GetMapping("/add")
    public String addGET(HttpSession httpSession, Model model){

        model.addAttribute("categories",
                this.categoryService
                .getAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryVM.class))
                .collect(Collectors.toList()));

        return httpSession.getAttribute("token") == null ? "redirect:/" : "add-product";
    }


    @PostMapping("/add")
    public String addPOST(@Valid @ModelAttribute(name = "itemModel") ItemBM itemModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("itemModel",itemModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemModel",bindingResult);

            return "redirect:/products/add";
        }

        this.itemService.save(this.modelMapper.map(itemModel, ItemDTO.class),
                (UUID) httpSession.getAttribute("token"));

        return "redirect:/products";
    }

    @GetMapping("/details/{id}")
    public String productDetails(@PathVariable(name = "id") String id,
                                 Model model,
                                 HttpSession httpSession){


        UUID uuid = UUID.fromString(id);

        ItemVM itemVM = this.modelMapper.map(this.itemService.getById(uuid),ItemVM.class);
        model.addAttribute("accessDelete", itemVM.getOwnerId().toString().equals(((UUID) httpSession.getAttribute("token")).toString()));

        model.addAttribute("item",itemVM);



        return httpSession.getAttribute("token") == null ? "redirect:/" : "details-product";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable(name = "id") String id,
                             HttpSession httpSession){
        UUID uuid = UUID.fromString(id);
        this.itemService.deleteItem(uuid,(UUID)  httpSession.getAttribute("token"));

        return "redirect:/products";
    }
}

