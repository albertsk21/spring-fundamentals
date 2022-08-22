package com.market.supermarket.model.dtos;

import com.market.supermarket.commons.ExceptionMessages;

public class ShopDto {

    private Long id;
    private String name;
    private String address;
    private String town;

    public ShopDto() {
    }

    public Long getId() {
        return id;
    }

    public ShopDto setId(Long id) {

        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShopDto setName(String name) {

        if(name.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ShopDto setAddress(String address) {


        if(address == null || address.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        this.address = address;
        return this;
    }

    public String getTown() {
        return town;
    }

    public ShopDto setTown(String town) {
        this.town = town;
        return this;
    }
}
