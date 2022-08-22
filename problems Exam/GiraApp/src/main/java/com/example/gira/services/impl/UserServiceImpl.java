package com.example.gira.services.impl;

import com.example.gira.domain.entities.User;
import com.example.gira.domain.dtos.UserDTO;
import com.example.gira.repositories.UserRepository;
import com.example.gira.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UUID getIdByEmailAndPassword(String email, String password) {
        return this.userRepository.findUserIdByEmailAndPassword(email,password).orElse(null);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO,User.class);
        this.userRepository.save(user);
    }
}
