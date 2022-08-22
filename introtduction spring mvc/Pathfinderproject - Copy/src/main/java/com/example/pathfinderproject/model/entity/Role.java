package com.example.pathfinderproject.model.entity;

import com.example.pathfinderproject.model.entity.enums.RoleNameEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private RoleNameEnum role;

    public Role() {
    }


    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRole() {
        return role;
    }


    public void setRole(RoleNameEnum role) {
        this.role = role;
    }
}



