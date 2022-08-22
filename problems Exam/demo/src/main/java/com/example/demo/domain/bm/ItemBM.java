package com.example.demo.domain.bm;

import com.example.demo.domain.enums.GenderNameEnum;
import com.example.demo.domain.enums.OptionNameEnum;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ItemBM {
    @Size(min = 3,message = "Name length must be more than three characters")
    private String name;
    @Size(min = 3,message = "Description length must be more than three characters")
    private String description;
    private OptionNameEnum category;
    private GenderNameEnum gender;
    @Positive(message = "Price must be positive number")
    private double price;

    public ItemBM() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OptionNameEnum getCategory() {
        return category;
    }

    public void setCategory(OptionNameEnum category) {
        this.category = category;
    }

    public GenderNameEnum getGender() {
        return gender;
    }

    public void setGender(GenderNameEnum gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
