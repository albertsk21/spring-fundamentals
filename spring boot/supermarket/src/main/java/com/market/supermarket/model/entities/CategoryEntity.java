package com.market.supermarket.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    public CategoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public CategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public CategoryEntity setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }
}
