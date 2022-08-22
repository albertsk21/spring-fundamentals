package com.example.demo.domain.dtos;

import com.example.demo.domain.enums.GenderNameEnum;
import com.example.demo.domain.enums.OptionNameEnum;

import java.util.UUID;

public class ItemDTO {

    private UUID id;
    private String name;
    private String description;
    private double price;
    private OptionNameEnum category;
    private GenderNameEnum gender;
    private UUID ownerId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
