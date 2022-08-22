package com.example.battleships.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(HttpSession httpSession){
        if(httpSession.getAttribute("token") != null){
            return "redirect:/ships";
        }
        return "index";
    }
}
