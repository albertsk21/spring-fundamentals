package com.market.supermarket.model.dtos;

import com.market.supermarket.commons.ExceptionMessages;
import com.market.supermarket.model.entities.ShopEntity;

public class SellerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private String shopName;
    private String manager;


    public SellerDto() {
    }

    public Long getId() {
        return id;
    }

    public SellerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SellerDto setFirstName(String firstName) {

        if (firstName == null || firstName.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SellerDto setLastName(String lastName) {

        if (lastName == null || lastName.length() < 2){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_MIN_2_CHARACTERS);
        }
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public SellerDto setAge(int age) {

        if(age < 18 ){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SELLER_AGE);
        }

        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public SellerDto setSalary(double salary) {


        if (salary < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SELLER_SALARY);
        }
        this.salary = salary;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public SellerDto setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public SellerDto setManager(String manager) {
        this.manager = manager;
        return this;
    }
}
