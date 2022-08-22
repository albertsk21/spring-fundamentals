package com.example.gira.domain.bm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterBM {


    @Size(min = 3, max = 20, message = "Username must be between 3 characters!")
    public String username;

    @NotEmpty(message = "Email cant be empty")
    public String email;
    @Size(min = 3, max = 20, message = "Password must be between 3 characters!")

    public String password;

    public RegisterBM() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
