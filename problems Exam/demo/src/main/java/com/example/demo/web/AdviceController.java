package com.example.demo.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class AdviceController {


    @ModelAttribute(name = "isLogged")
    public boolean isLogged(HttpSession httpSession){
        return httpSession.getAttribute("token") != null;
    }

}
