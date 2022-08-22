package com.example.shoopinglist.model.bm;

import com.example.shoopinglist.util.validation.annotations.IsNotInThePast;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ProductBM {


    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    private String name;


    @Size(min = 5, message = "Description length must be more than 5 symbols")
    private String  description;

    @IsNotInThePast(message = "The date cannot be in the past")
    @DateTimeFormat( iso = ISO.DATE_TIME)
    private LocalDateTime before;
    @Positive(message = "Price must be positive number")
    private double price;
    @NotEmpty(message = "Category cannot be empty")
    private String category;


    public ProductBM() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBefore() {
        return before;
    }

    public void setBefore(LocalDateTime before) {
        this.before = before;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
