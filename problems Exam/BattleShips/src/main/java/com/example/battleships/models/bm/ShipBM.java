package com.example.battleships.models.bm;


import com.example.battleships.models.enums.CategoryNameEnum;
import com.example.battleships.util.validation.annotations.IsNotInTheFuture;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipBM {

    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    private String name;
    @Positive(message = "The health must be positive")
    private int health;
    @Positive(message = "The power must be positive")
    private int power;
    @IsNotInTheFuture(message = "Created date cannot be in the future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created;
    @NotNull(message = "You must select the category")
    private CategoryNameEnum category;

    public ShipBM() {
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
}
