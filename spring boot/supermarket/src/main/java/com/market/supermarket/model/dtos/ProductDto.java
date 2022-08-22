package com.market.supermarket.model.dtos;


import com.market.supermarket.commons.ExceptionMessages;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductDto {

    private Long id;
    private LocalDate bestBefore;
    private String description;
    private String name;
    private double price;
    private String category;


    public Long getId() {
        return id;
    }

    public ProductDto setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public ProductDto setBestBefore(String bestBefore) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.bestBefore = LocalDate.parse(bestBefore,dateTimeFormatter);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        if (name == null || name.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRODUCT_PRICE);
        }
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductDto setCategory(String category) {
        this.category = category;
        return this;
    }
}
