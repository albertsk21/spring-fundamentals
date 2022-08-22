package com.market.supermarket.model.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "shops")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String address;
    private String name;
    @ManyToOne
    @JoinColumn(name = "town_id")
    private TownEntity town;
    @OneToMany(mappedBy = "shop")
    private List<SellerEntity> sellers;

    @ManyToMany(mappedBy = "shops", fetch = FetchType.EAGER)
    private List<ProductEntity> products;
    public ShopEntity() {
    }

    public String getAddress() {
        return address;
    }

    public ShopEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public ShopEntity setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }

    public List<SellerEntity> getSellers() {
        return sellers;
    }

    public ShopEntity setSellers(List<SellerEntity> sellers) {
        this.sellers = sellers;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ShopEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShopEntity setName(String name) {
        this.name = name;
        return this;
    }

    public TownEntity getTown() {
        return town;
    }

    public ShopEntity setTown(TownEntity town) {
        this.town = town;
        return this;
    }
}
