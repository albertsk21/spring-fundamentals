package com.example.shoopinglist.web;

import com.example.shoopinglist.model.bm.ProductBM;
import com.example.shoopinglist.model.dto.ProductDTO;
import com.example.shoopinglist.service.CategoryService;
import com.example.shoopinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {


    private CategoryService categoryService;
    private ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @ModelAttribute(name = "productModel")
    public ProductBM productModel(){
        return new ProductBM();
    }

    @GetMapping("")
    public String home(Model model,
                       HttpSession httpSession){


        boolean tokenNotExist = httpSession.getAttribute("token") == null;

        if(tokenNotExist){
            return "redirect:/";
        }

        this.logUser(model,httpSession);
        model.addAttribute("productsFood",this.productService.getProductsByCategoryName("Food"));
        model.addAttribute("productsDrink",this.productService.getProductsByCategoryName("Drink"));
        model.addAttribute("productsHousehold",this.productService.getProductsByCategoryName("Household"));
        model.addAttribute("otherProducts",this.productService.getProductsByCategoryName("Other"));
        model.addAttribute("sumProducts",this.productService.getSumOfAllProducts());
        return "home";
    }

    @GetMapping("/add")
    public String productAddGet(Model model,
                                HttpSession httpSession){
        this.logUser(model,httpSession);
        if (httpSession.getAttribute("token") == null)
            return "redirect:/";

        model.addAttribute("categories",categoryService.getAll());
        return "product-add";
    }




    @PostMapping("/add")
    public String productAddPost(@Valid @ModelAttribute ProductBM productModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productModel",productModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productModel",bindingResult);
            return "redirect:/products/add";
        }


        ProductDTO productDTO = new ProductDTO()
                .setName(productModel.getName())
                .setCategory(productModel.getCategory())
                .setDescription(productModel.getDescription())
                .setPrice(productModel.getPrice());


        if (productModel.getBefore() != null){
            productDTO.convertToLocalDateTime(productModel.getBefore());
        }
        this.productService.save(productDTO);

        return "redirect:/products";
    }

    private void logUser(Model model,
                         HttpSession httpSession){
        Object token = httpSession.getAttribute("token");
        boolean isLogged = token != null;
        model.addAttribute("isLogged",isLogged);
    }

}
