package com.example.pathfinderproject.model.view;

import com.example.pathfinderproject.model.entity.enums.UserLevelEnum;

public class UserVM {
    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private UserLevelEnum level;


    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }

    public UserLevelEnum getLevel() {
        return level;
    }
}
