package com.example.shoopinglist.model.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {


    private String name;
    private String description;
    private Date before;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ProductEntity() {
        super();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Date getBefore() {
        return before;
    }
    public CategoryEntity getCategory() {
        return category;
    }
    public UserEntity getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setBefore(Date before) {
        this.before = before;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
