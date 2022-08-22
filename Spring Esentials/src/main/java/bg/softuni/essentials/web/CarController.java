package bg.softuni.essentials.web;

import bg.softuni.essentials.model.CarDTO;
import bg.softuni.essentials.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("cars",this.carService.getAllCars());
        return "all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("car",this.carService.findById(id).orElseThrow());
        return "details";
    }

}
