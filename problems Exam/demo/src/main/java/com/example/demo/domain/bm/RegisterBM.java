package com.example.demo.domain.bm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RegisterBM {

    @Size(min = 2, message = "Username must be than two characters!")
    private String username;
    @NotEmpty(message = "Email must contain '@'")
    @Email(message = "Email must contain '@'")
    private String email;
    @Positive(message = "Price must be a positive number")
    private double budget;
    @Size(min = 2, message = "Password must be than two characters!")
    private String password;


    public RegisterBM() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public double getBudget() {
        return budget;
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

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
