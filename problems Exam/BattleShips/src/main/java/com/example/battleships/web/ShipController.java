package com.example.battleships.web;

import com.example.battleships.models.bm.AttackShips;
import com.example.battleships.models.bm.ShipBM;
import com.example.battleships.models.dtos.ShipDTO;
import com.example.battleships.models.vm.ShipVM;
import com.example.battleships.services.ShipService;
import com.example.battleships.util.tools.RedirectPath;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private ShipService shipService;
    private ModelMapper modelMapper;


    @ModelAttribute("shipModel")
    public ShipBM shipModel(){
        return new ShipBM();
    }

    @ModelAttribute("attackShipsModel")
    public AttackShips attackShipsModel(){
        return new AttackShips();
    }
    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public String home(HttpSession httpSession, Model model){
        model.addAttribute("ships",
                this.shipService.getAll()
                        .stream()
                        .map(s -> this.modelMapper.map(s, ShipVM.class) )
                        .collect(Collectors.toList()));



        UUID uuid = (UUID) httpSession.getAttribute("token");
        if ( uuid == null) return "redirect:/";


        model.addAttribute("myShipsModels",this.shipService.findByUserId(uuid)
                .stream().map(s -> this.modelMapper.map(s,ShipVM.class))
                .collect(Collectors.toList()));

        model.addAttribute("enemiesShipsModels",this.shipService.findWithoutUserId(uuid)
                .stream().map(s -> this.modelMapper.map(s,ShipVM.class))
                .collect(Collectors.toList()));

        model.addAttribute("attacker", "");
        model.addAttribute("defenderName", "");

        return RedirectPath.redirectToHome(httpSession,"home");
    }

    @GetMapping("/add")
    public String addShipGET(HttpSession httpSession){



        return RedirectPath.redirectToHome(httpSession,"ship-add");
    }


    @PostMapping("/add")
    public String addShipPost(@Valid @ModelAttribute(name = "shipModel") ShipBM shipBM,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              HttpSession httpSession){


        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("shipModel", shipBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipModel",bindingResult);
            return "redirect:/ships/add";
        }

        ShipDTO shipDTO = this.modelMapper.map(shipBM, ShipDTO.class);
        shipDTO.setUserId((UUID) httpSession.getAttribute("token"));

        this.shipService.save(shipDTO);
        return "redirect:/ships";
    }



    @PostMapping("/attack")
    public String attackShip(@Valid @ModelAttribute AttackShips attackShipsModel,
                             BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            this.shipService.attackShip(attackShipsModel.getAttackerName(),attackShipsModel.getDefenderName());

        }
        return "redirect:/ships";
    }

}
