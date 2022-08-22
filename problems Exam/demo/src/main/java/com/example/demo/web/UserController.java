package com.example.demo.web;

import com.example.demo.domain.bm.LoginBM;
import com.example.demo.domain.bm.RegisterBM;
import com.example.demo.domain.dtos.UserDTO;
import com.example.demo.services.UserService;
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


    @ModelAttribute(name = "userFounded")
    public boolean userFounded(){
        return true;
    }

    @ModelAttribute(name = "loginModel")
    public LoginBM loginModel(){
        return new LoginBM();
    }

    @ModelAttribute(name = "registerModel")
    public RegisterBM registerModel(){
        return new RegisterBM();
    }

    @GetMapping("/login")
    public String loginGET(HttpSession httpSession){
        return httpSession.getAttribute("token") != null ? "redirect:/" : "login";
    }
    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute LoginBM loginModel,
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

        httpSession.setAttribute("token",id);

        return "redirect:/products";
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
