package com.example.heroes.web;

import com.example.heroes.model.bm.LoginBM;
import com.example.heroes.model.bm.RegisterBM;
import com.example.heroes.model.dtos.UserDTO;
import com.example.heroes.service.UserService;
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

    private ModelMapper modelMapper;
    private UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("registerModel")
    public RegisterBM registerModel(){
        return new RegisterBM();
    }

    @ModelAttribute("loginModel")
    public LoginBM loginModel(){
        return new LoginBM();
    }

    @GetMapping("/login")
    public String loginGET(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPOST(@Valid @ModelAttribute("loginModel")LoginBM loginBM,
                            RedirectAttributes redirectAttributes,
                            HttpSession httpSession,
                             BindingResult bindingResult){




        UUID uuid = this.userService.findIdByUsernameAndPassword(loginBM.getUsername(),loginBM.getPassword());
        if(uuid == null){
            redirectAttributes.addFlashAttribute("loginModel",loginBM);
            return "redirect:/users/login";
        }

        httpSession.setAttribute("token",uuid);
        return "redirect:/";
    }
    @GetMapping("/register")
    public String registerGET(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(@Valid @ModelAttribute RegisterBM registerBM,
                               BindingResult bindingResult){
        UserDTO userDTO = this.modelMapper.map(registerBM,UserDTO.class);
        this.userService.save(userDTO);
        return "redirect:/users/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){

        httpSession.removeAttribute("token");

        return "redirect:/";
    }


}
