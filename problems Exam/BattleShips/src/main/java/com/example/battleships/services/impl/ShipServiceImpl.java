package com.example.battleships.services.impl;


import com.example.battleships.models.dtos.ShipDTO;
import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {


    private ShipRepository shipRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShipDTO> getAll() {
        return this.shipRepository.findAll()
                .stream()
                .map(s -> this.modelMapper.map(s,ShipDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ShipDTO shipDTO) {

        User user  = this.userRepository.findUserById(shipDTO.getUserId());
        Category category = this.categoryRepository.findCategoryByName(shipDTO.getCategory());
        if (user == null) throw new IllegalArgumentException("User not found");
        Ship shipEntity = this.modelMapper.map(shipDTO,Ship.class);
        shipEntity.setUser(user);
        shipEntity.setCategory(category);
        this.shipRepository.save(shipEntity);

    }

    @Override
    public List<ShipDTO> findByUserId(UUID uuid) {
        Function<Ship,ShipDTO> convertToShipDTO = s -> this.modelMapper.map(s,ShipDTO.class);
        return this.shipRepository.findShipsByUserId(uuid)
                .stream()
                .map(convertToShipDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipDTO> findWithoutUserId(UUID uuid) {
        Function<Ship,ShipDTO> convertToShipDTO = s -> this.modelMapper.map(s,ShipDTO.class);
        return this.shipRepository.findShipsByDifferentUserId(uuid)
                .stream()
                .map(convertToShipDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void attackShip(String attackerShipName, String defenderShipName) {


        Ship attacker = this.shipRepository.findShipByName(attackerShipName);
        Ship defender = this.shipRepository.findShipByName(defenderShipName);
        int defenderCurrentHealth = defender.getHealth() - attacker.getPower();


        if(defenderCurrentHealth <= 0){


            this.shipRepository.deleteById(defender.getId());

        }else{
            defender.setHealth(defenderCurrentHealth);
            this.shipRepository.save(defender);
        }

    }
}

