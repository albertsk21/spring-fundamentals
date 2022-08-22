package com.example.shoopinglist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @GetMapping("")
    public String index(Model model,
                        HttpSession httpSession){


        Object token = httpSession.getAttribute("token");
        if(token != null) return "redirect:/products";
        model.addAttribute("isLogged",false);

        return "index";
    }

}
