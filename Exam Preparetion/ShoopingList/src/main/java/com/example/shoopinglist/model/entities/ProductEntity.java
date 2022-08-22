package com.example.shoopinglist.model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {


    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private Date expiration;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @ManyToMany(mappedBy = "products")
    private List<UserEntity> users;

    public ProductEntity() {
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

    public Date getExpiration() {
        return expiration;
    }

    public ProductEntity setExpiration(Date expiration) {
        this.expiration = expiration;
        return this;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public ProductEntity setUsers(List<UserEntity> users) {
        this.users = users;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
