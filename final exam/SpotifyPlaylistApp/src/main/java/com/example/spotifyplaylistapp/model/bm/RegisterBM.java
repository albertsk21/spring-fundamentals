package com.example.spotifyplaylistapp.model.bm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterBM {

    @Size(min = 3, max = 20 , message = "Username length must be between 3 and 20 characters!")
    private String username;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Size(min = 3, max = 20 , message = "Password length must be between 3 and 20 characters!")
    private String password;
    private String confirmPassword;

    public RegisterBM() {
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

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
