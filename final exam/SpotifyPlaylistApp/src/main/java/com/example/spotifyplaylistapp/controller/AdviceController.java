package com.example.spotifyplaylistapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class AdviceController {
    @ModelAttribute("isLogged")
    public boolean isLogged(HttpSession httpSession){
        return httpSession.getAttribute("userId") != null;
    }
}
