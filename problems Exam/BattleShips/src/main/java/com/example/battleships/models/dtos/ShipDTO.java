package com.example.battleships.models.dtos;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.CategoryNameEnum;

import java.time.LocalDate;
import java.util.UUID;

public class ShipDTO {


    private String name;
    private int health;
    private int power;
    private LocalDate created;
    private CategoryNameEnum category;
    private UUID userId;

    public ShipDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public UUID getUserId() {
        return userId;
    }
}
