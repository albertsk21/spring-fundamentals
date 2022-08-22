package com.example.shoopinglist.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    private String name;
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<ProductEntity> products;

    public CategoryEntity() {
        super();
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<ProductEntity> getProducts() {
        return products;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
    public void setName(String name) {
        this.name = name;
    }



}
