package com.example.demo.services.impl;

import com.example.demo.domain.dtos.UserDTO;
import com.example.demo.domain.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
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
    public UUID getIdByUsernameAndPassword(String username, String password) {
        return this.userRepository.findUserIdByUsernameAndPassword(username,password).orElse(null);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        this.userRepository.save(this.modelMapper.map(userDTO, User.class));
    }
}
