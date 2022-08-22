package com.example.battleships.models.dtos;

import com.example.battleships.models.enums.CategoryNameEnum;

import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    private CategoryNameEnum name;
    private String description;


    public CategoryDTO() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
