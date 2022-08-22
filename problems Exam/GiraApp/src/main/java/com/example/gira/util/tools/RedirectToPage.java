package com.example.gira.util.tools;

import javax.servlet.http.HttpSession;

public class RedirectToPage {


    public static String redirectToTasksPage(HttpSession httpSession, String fileName){
        return httpSession.getAttribute("token") != null ? "redirect:/tasks" : fileName;
    }

}
