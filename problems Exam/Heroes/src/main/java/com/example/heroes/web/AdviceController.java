package com.example.heroes.web;

import com.example.heroes.model.bm.UserBM;
import com.example.heroes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@ControllerAdvice
public class AdviceController {

    private UserService userService;
    private ModelMapper modelMapper;

    public AdviceController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("isLogged")
    public boolean isLogged(HttpSession httpSession){
        return httpSession.getAttribute("token") != null;
    }

    @ModelAttribute("userModel")
    public UserBM userModel(HttpSession httpSession){

        UUID id =(UUID) httpSession.getAttribute("token");
        if(id == null){
            UserBM userBM = new UserBM();
            userBM.setUsername("");
            userBM.setCountry("");
            userBM.setEmail("");
            return userBM;
        }
        return this.modelMapper.map(this.userService.getUser(id),UserBM.class);
    }
}
