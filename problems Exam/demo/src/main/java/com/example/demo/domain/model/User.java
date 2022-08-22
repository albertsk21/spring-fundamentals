package com.example.demo.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{



    private String username;
    private String password;
    private String email;
    private double budget;
    private List<Item> items;

    public User() {
    }


    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public double getBudget() {
        return budget;
    }


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
