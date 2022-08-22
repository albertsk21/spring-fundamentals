package com.market.supermarket.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "best_before")
    private LocalDate bestBefore;
    @Column(length = 1000)
    private String description;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ShopEntity> shops;



    public ProductEntity() {
    }

    public List<ShopEntity> getShops() {
        return shops;
    }

    public ProductEntity setShops(List<ShopEntity> shops) {
        this.shops = shops;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public ProductEntity setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ProductEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }
}
