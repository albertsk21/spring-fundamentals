package com.example.shoopinglist.model.dto;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ProductDTO {

    private String name;
    private String  description;
    private Date before;
    private double price;
    private String category;


    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getBefore() {
        return before;
    }

    public ProductDTO setBefore(Date before) {
        this.before = before;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProductDTO convertToLocalDateTime(LocalDateTime localDateTime){
        this.before  = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return this;
    }

}
