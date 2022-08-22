package com.example.spotifyplaylistapp.controller;


import com.example.spotifyplaylistapp.model.bm.LoginBM;
import com.example.spotifyplaylistapp.model.bm.RegisterBM;
import com.example.spotifyplaylistapp.model.dtos.UserDTO;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute(name = "loginModel")
    public LoginBM loginModel(){
        return new LoginBM();
    }

    @ModelAttribute("registerModel")
    public RegisterBM registerModel(){
        return new RegisterBM();
    }


    @ModelAttribute("userFounded")
    public boolean userFounded(){
        return true;
    }

    @GetMapping("/login")
    public String loginGET(HttpSession httpSession){
        return httpSession.getAttribute("userId") != null ? "redirect:/songs" : "login";
    }


    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute(name = "loginModel") LoginBM loginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            HttpSession httpSession){
        UUID id = this.userService.getIdByUsernameAndPassword(loginModel.getUsername(),loginModel.getPassword());

        if(bindingResult.hasErrors() || id == null){

            redirectAttributes.addFlashAttribute("userFounded", false);
            redirectAttributes.addFlashAttribute("loginModel",loginModel);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",bindingResult);
            return "redirect:/users/login";
        }

        httpSession.setAttribute("userId",id);

        return "redirect:/songs";
    }

    @GetMapping("/register")
    public String registerGET(HttpSession httpSession){
        return httpSession.getAttribute("userId") != null ? "redirect:/songs" : "register";

    }
    @PostMapping("/register")
    public String registerPOST(@Valid @ModelAttribute(name = "registerModel") RegisterBM registerModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerModel",registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel",bindingResult);

            return "redirect:/users/register";
        }

        this.userService.saveUser(this.modelMapper.map(registerModel, UserDTO.class));
        return "redirect:/users/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("userId");
        return "redirect:/";
    }
}
