package com.example.heroes.model.entities;

import com.example.heroes.model.enums.OptionEnumName;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {


    private String name;
    private OptionEnumName optional;
    private int level;
    private User user;

    public void setName(String name) {
        this.name = name;
    }


    public Hero() {
    }

    public void setOptional(OptionEnumName optional) {
        this.optional = optional;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }

    @Enumerated(EnumType.STRING)
    public OptionEnumName getOptional() {
        return optional;
    }


    public int getLevel() {
        return level;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
}
