package com.market.supermarket.model.dtos;

import com.market.supermarket.commons.ExceptionMessages;

public class CategoryDto {

    private Long id;
    private String name;


    public CategoryDto(String name) {
        this.setName(name);
    }

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        this.name = name;
    }
}
