package com.market.supermarket.model.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "towns")
public class TownEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "town")
    private List<ShopEntity> shops;

    public TownEntity() {
    }

    public List<ShopEntity> getShops() {
        return shops;
    }

    public TownEntity setShops(List<ShopEntity> shops) {
        this.shops = shops;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TownEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TownEntity setName(String name) {
        this.name = name;
        return this;
    }
}
