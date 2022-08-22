package com.example.pathfinderproject.service.impl;

import com.example.pathfinderproject.model.entity.User;
import com.example.pathfinderproject.model.entity.enums.UserLevelEnum;
import com.example.pathfinderproject.model.service.UserServiceModel;
import com.example.pathfinderproject.repository.UserRepository;
import com.example.pathfinderproject.service.UserService;
import com.example.pathfinderproject.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel map) {
        User user =  this.modelMapper.map(map, User.class);
        user.setLevel(UserLevelEnum.BEGINNER);
        this.userRepository.save(user);
    }

    @Override
    public void loginUser(UserServiceModel user) {
        this.currentUser.setUsername(user.getUsername());
        this.currentUser.setId(user.getId());
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        User user = this.userRepository.findByUsernameAndPassword(username,password);

        if (user != null){
            return this.modelMapper.map(user,UserServiceModel.class);
        }

        return null;
    }

    @Override
    public UserServiceModel findById(Long id) {
        User user = this.userRepository.findUserById(id);

        if (user != null){
            return this.modelMapper.map(user,UserServiceModel.class);
        }

        return null;
    }

    @Override
    public void logout() {
        this.currentUser.setId(null);
        this.currentUser.setUsername(null);
    }

    @Override
    public boolean isLogged() {
        return this.currentUser.getId() != null;
    }

    @Override
    public User findUserEntity() {
        return this.userRepository.findById(this.currentUser.getId()).orElse(null);
    }


}
