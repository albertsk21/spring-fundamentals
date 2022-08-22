package com.example.battleships.services.impl;

import com.example.battleships.models.dtos.UserDTO;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.services.UserService;
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
        this.userRepository.save(this.modelMapper.map(userDTO, User.class));
    }

    @Override
    public UserDTO findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findUserByUsernameAndPassword(username,password);
        if(user == null){
            return null;
        }
        return this.modelMapper.map(user,UserDTO.class);
    }

    @Override
    public String getIdByUsername(String username) {
        return this.userRepository.findIdByUsername(username).toString();
    }

    @Override
    public UserDTO getById(UUID uuid) {
        return this.modelMapper.map(this.userRepository.findUserById(uuid),UserDTO.class);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findUserByUsername(username),UserDTO.class);
    }


}
