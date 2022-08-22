package com.example.shoopinglist.model.bm;

import com.example.shoopinglist.util.validation.annotations.IsValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterBM {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    public String username;
    @NotEmpty(message = "Email cannot be empty")
    public String email;
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    public String password;
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    public String confirmPassword;



    public RegisterBM() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
