package com.example.battleships.util.tools;

import javax.servlet.http.HttpSession;

public class RedirectPath {
    public static String redirectToHome(HttpSession httpSession, String path){
        return httpSession.getAttribute("token") == null ? "redirect:/" : path;
    }
}
