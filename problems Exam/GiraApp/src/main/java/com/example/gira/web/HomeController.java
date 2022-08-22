package com.example.gira.web;

import com.example.gira.util.tools.RedirectToPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index(HttpSession httpSession){
        return RedirectToPage.redirectToTasksPage(httpSession, "index");
    }

}
