package com.example.demo.domain.dtos;

import com.example.demo.domain.enums.OptionNameEnum;

public class CategoryDTO {

    private OptionNameEnum option;
    private String description;

    public CategoryDTO() {
    }

    public OptionNameEnum getOption() {
        return option;
    }

    public void setOption(OptionNameEnum option) {
        this.option = option;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
