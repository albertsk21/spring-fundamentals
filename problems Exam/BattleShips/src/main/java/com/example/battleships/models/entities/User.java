package com.example.battleships.models.entities;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String username;
    private String fullName;
    private String password;
    private String email;
    private List<Ship> ships;


    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "full_name",unique = true)
    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public List<Ship> getShips() {
        return ships;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
