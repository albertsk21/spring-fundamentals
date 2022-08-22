package com.example.demo.domain.model;

import com.example.demo.domain.enums.GenderNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    private String name;
    private String description;
    private double price;
    private Category category;
    private GenderNameEnum gender;
    private User user;



    @Column(unique = true)
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }


    @Enumerated(EnumType.STRING)
    public GenderNameEnum getGender() {
        return gender;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setGender(GenderNameEnum gender) {
        this.gender = gender;
    }
}
