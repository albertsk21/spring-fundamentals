package com.example.battleships.models.bm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterBM {



    @Size(min = 3, max = 20, message = "Username length must 3 and 10 characters")
    private String username;

    @Size(min = 5, max = 20, message = "Full name length must 3 and 10 characters")
    private String fullName;

    @NotEmpty(message = "Enter a valid email")
    @Email(message = "Enter a valid email" )
    private String email;
    @Size(min = 3, message = "Password length must be more 3 characters")
    private String password;
    @Size(min = 3, message = "Password length must be more 3 characters")
    private String confirmPassword;


    public RegisterBM() {
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
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
