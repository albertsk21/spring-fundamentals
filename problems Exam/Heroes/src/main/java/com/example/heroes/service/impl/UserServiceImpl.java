package com.example.heroes.service.impl;

import com.example.heroes.model.dtos.UserDTO;
import com.example.heroes.model.entities.User;
import com.example.heroes.repository.UserRepository;
import com.example.heroes.service.UserService;
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
    public void save(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO,User.class);
        this.userRepository.save(user);
    }

    @Override
    public UUID findIdByUsernameAndPassword(String username, String password) {
        return this.userRepository.findIdByUsernameAndPassword(username,password).orElse(null);
    }

    @Override
    public UserDTO getUser(UUID id) {
        return this.modelMapper
                .map(this.userRepository.findUserById(id),UserDTO.class);
    }
}
