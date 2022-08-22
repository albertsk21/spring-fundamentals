package com.example.gira.services;

import com.example.gira.domain.dtos.UserDTO;

import java.util.UUID;

public interface UserService {


    UUID getIdByEmailAndPassword(String email, String password);
    void saveUser(UserDTO userDTO);
}
