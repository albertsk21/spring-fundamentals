package com.example.battleships.web;

import com.example.battleships.models.bm.LoginBM;
import com.example.battleships.models.bm.RegisterBM;
import com.example.battleships.models.dtos.UserDTO;
import com.example.battleships.services.UserService;
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

    @ModelAttribute(name = "registerModel")
    public RegisterBM registerModel(){
        return new RegisterBM();
    }


    @ModelAttribute(name = "loginModel")
    public LoginBM loginModel(){
        return new LoginBM();
    }

    @GetMapping("/login")
    public String loginGet(HttpSession httpSession){
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(@Valid @ModelAttribute RegisterBM registerModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerModel", registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel",bindingResult);
            return "redirect:/users/register";
        }

        this.userService.save(this.modelMapper.map(registerModel, UserDTO.class));
        return "redirect:/users/login";
    }
    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute LoginBM loginModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                            HttpSession httpSession){
        UserDTO user = this.userService.findByUsernameAndPassword(loginModel.getUsername(),loginModel.getPassword());

        if(bindingResult.hasErrors() || user == null ){
            redirectAttributes.addFlashAttribute("loginModel", loginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginModel",bindingResult);
            return "redirect:/users/login";
        }


        UserDTO userDTO = this.userService.findUserByUsername(loginModel.getUsername());
        httpSession.setAttribute("token",userDTO.getId());

        return "redirect:/ships";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){

        httpSession.removeAttribute("token");
        return "redirect:/";
    }

}
