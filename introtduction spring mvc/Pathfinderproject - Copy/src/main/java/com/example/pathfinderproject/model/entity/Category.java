package com.example.pathfinderproject.model.entity;

import com.example.pathfinderproject.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{


    private String description;
    private CategoryNameEnum name;

    public Category() {
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
}
