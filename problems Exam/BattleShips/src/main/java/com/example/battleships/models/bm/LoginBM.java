package com.example.battleships.models.bm;

import javax.validation.constraints.Size;

public class LoginBM {
    @Size(min = 3, max = 20, message = "Username length must 3 and 10 characters")
    private String username;
    @Size(min = 3, message = "Password length must be more 3 characters")
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
