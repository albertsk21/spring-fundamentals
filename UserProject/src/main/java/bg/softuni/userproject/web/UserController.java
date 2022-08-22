package bg.softuni.userproject.web;

import bg.softuni.userproject.model.dtos.UserDTO;
import bg.softuni.userproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("users",this.userService.getAll());
        return "all";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new UserDTO());
        return "create";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute(name = "user") UserDTO userDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            this.userService.save(userDTO);
        }
        return "redirect:all";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        this.userService.delete(id);
        return "redirect:/users/all";
    }


    @GetMapping("/edit/{id}")
    public String getEditUserPage(@PathVariable Long id, Model model){
        model.addAttribute("user",this.userService.findById(id));
        return "edit";
    }

    @PutMapping("/edit")
    public String editUser(@ModelAttribute(name = "user") UserDTO userDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:edit";
        }
        this.userService.save(userDTO);
        return "redirect:/users/all";
    }

}
