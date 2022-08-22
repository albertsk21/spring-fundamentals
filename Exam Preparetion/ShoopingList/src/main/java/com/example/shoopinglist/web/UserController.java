package com.example.shoopinglist.web;

import com.example.shoopinglist.model.bm.LoginBM;
import com.example.shoopinglist.model.bm.RegisterBM;
import com.example.shoopinglist.model.dto.UserDTO;
import com.example.shoopinglist.service.UserService;
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

@Controller
@RequestMapping("/users")
public class UserController {



    private ModelMapper modelMapper;
    private UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
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
    public String loginGET(){
        return "login";
    }


    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute LoginBM loginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            HttpSession httpSession){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginModel",loginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",bindingResult);
            return "redirect:/users/login";
        }


        if(this.userService.existUserByPasswordAndUsername(loginModel)){
            httpSession.setAttribute("token",this.userService.getTokenByUsername(loginModel.getUsername()));
        }else {
            redirectAttributes.addFlashAttribute("loginModel",loginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",bindingResult);
            return "redirect:/users/login";
        }

        return "redirect:/products";
    }


    @GetMapping("/register")
    public String registerGET(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(@Valid @ModelAttribute RegisterBM registerModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){


        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerModel",registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel",bindingResult);
            return "redirect:/users/register";
        }

        this.userService.save(this.modelMapper.map(registerModel, UserDTO.class));

        return "redirect:/users/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){


        httpSession.removeAttribute("token");

        return "redirect:/";
    }
}
