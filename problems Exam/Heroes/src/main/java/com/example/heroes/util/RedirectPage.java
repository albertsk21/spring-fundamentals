package com.example.heroes.util;

import javax.servlet.http.HttpSession;

public class RedirectPage {
    public static String redirectToIndex(HttpSession httpSession, String fileName){
        return httpSession.getAttribute("token") != null ? fileName : "redirect:/";
    }
}
