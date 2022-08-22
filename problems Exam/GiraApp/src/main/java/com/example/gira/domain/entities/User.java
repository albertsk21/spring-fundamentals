package com.example.gira.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {


    private String username;
    private String password;
    private String email;
    private List<Task> tasks;




    public User() {
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public List<Task> getTasks() {
        return tasks;
    }
}
