package com.example.shoopinglist.service.impl;


import com.example.shoopinglist.repositories.UserRepository;
import com.example.shoopinglist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
