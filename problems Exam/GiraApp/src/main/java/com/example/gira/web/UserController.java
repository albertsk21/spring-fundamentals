package com.example.gira.web;

import com.example.gira.domain.bm.LoginBM;
import com.example.gira.domain.bm.RegisterBM;
import com.example.gira.domain.dtos.UserDTO;
import com.example.gira.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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



    @ModelAttribute("userFounded")
    public boolean userFounded(){
        return true;
    }

    @GetMapping("/login")
    public String loginGET(HttpSession httpSession, Model model){



        return httpSession.getAttribute("token") != null ? "redirect:/tasks" : "login";
    }


    @ModelAttribute(name = "registerModel")
    public RegisterBM registerModel(){
        return new RegisterBM();
    }

    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute LoginBM loginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            HttpSession httpSession){
        UUID id = this.userService.getIdByEmailAndPassword(loginModel.getEmail(),loginModel.getPassword());




        if(bindingResult.hasErrors() || id == null){

            redirectAttributes.addFlashAttribute("userFounded", false);
            redirectAttributes.addFlashAttribute("loginModel",loginModel);


            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",bindingResult);
            return "redirect:/users/login";
        }


        httpSession.setAttribute("token",id);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerGET(HttpSession httpSession){
        return httpSession.getAttribute("token") != null ? "redirect:/tasks" : "register";

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
        httpSession.removeAttribute("token");

        return "redirect:/";
    }


}
