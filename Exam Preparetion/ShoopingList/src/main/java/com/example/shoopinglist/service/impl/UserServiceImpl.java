package com.example.shoopinglist.service.impl;


import com.example.shoopinglist.model.bm.LoginBM;
import com.example.shoopinglist.model.dto.UserDTO;
import com.example.shoopinglist.model.entities.UserEntity;
import com.example.shoopinglist.repositories.UserRepository;
import com.example.shoopinglist.service.UserService;
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
    public void save(UserDTO user) {

        UserEntity userEntity = this.modelMapper.map(user,UserEntity.class);
        userEntity.setId(UUID.randomUUID().toString());
        this.userRepository.save(userEntity);

    }

    @Override
    public boolean existUserByPasswordAndUsername(LoginBM loginBM) {
        return this.userRepository.
                findUserEntityByUsernameAndPassword(loginBM
                        .getUsername(),loginBM
                        .getPassword()) != null;
    }

    @Override
    public String getTokenByUsername(String username) {
        return this.userRepository.findIdByUsername(username);
    }
}
