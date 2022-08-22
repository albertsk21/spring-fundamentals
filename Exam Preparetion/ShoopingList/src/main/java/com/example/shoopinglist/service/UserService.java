package com.example.shoopinglist.service;

import com.example.shoopinglist.model.bm.LoginBM;
import com.example.shoopinglist.model.dto.UserDTO;

public interface UserService {

    void save(UserDTO user);
    boolean existUserByPasswordAndUsername(LoginBM loginBM);
    String getTokenByUsername(String username);
}
