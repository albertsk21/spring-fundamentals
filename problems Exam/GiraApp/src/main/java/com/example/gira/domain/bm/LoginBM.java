package com.example.gira.domain.bm;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginBM {

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    private String password;
    @NotEmpty(message = "Email cant be empty")
    private String email;

    public LoginBM() {
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
