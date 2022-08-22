package com.example.demo.services;

import com.example.demo.domain.dtos.UserDTO;

import java.util.UUID;

public interface UserService {

    UUID getIdByUsernameAndPassword(String username, String password);
    void saveUser(UserDTO userDTO);
}
