package com.example.demo.domain.bm;

import javax.validation.constraints.Size;

public class LoginBM {

    @Size(min = 2, message = "Username must be than two characters!")
    private String username;
    @Size(min = 2, message = "Password must be than two characters!")
    private String password;

    public LoginBM() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
