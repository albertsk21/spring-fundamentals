package com.example.shoopinglist.model.dto;

public class CategoryDTO {

    private String name;
    private String description;


    public CategoryDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
