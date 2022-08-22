package com.example.heroes.service;

import com.example.heroes.model.dtos.UserDTO;

import java.util.UUID;

public interface UserService {

    void save(UserDTO userDTO);
    UUID findIdByUsernameAndPassword(String username,String password);
    UserDTO getUser(UUID id);
}
