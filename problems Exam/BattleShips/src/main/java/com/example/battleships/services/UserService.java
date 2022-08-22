package com.example.battleships.services;

import com.example.battleships.models.dtos.UserDTO;

import java.util.UUID;

public interface UserService {

    void save(UserDTO userDTO);
    UserDTO findByUsernameAndPassword(String username, String password);
    String getIdByUsername(String username);
    UserDTO getById(UUID uuid);
    UserDTO findUserByUsername(String username);
}
