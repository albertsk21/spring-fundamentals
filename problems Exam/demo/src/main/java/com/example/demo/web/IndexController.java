package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("")
    public String index(HttpSession httpSession){
        return httpSession.getAttribute("token") != null ? "redirect:/products" : "index";
    }

}
