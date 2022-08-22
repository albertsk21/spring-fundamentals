package com.example.pathfinderproject.model.entity;

import com.example.pathfinderproject.model.entity.enums.UserLevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String fullName;
    private String username;
    private String password;
    private Integer age;
    private UserLevelEnum level;
    private Set<Role> roles;


    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    @Enumerated(EnumType.STRING)
    public UserLevelEnum getLevel() {
        return level;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
