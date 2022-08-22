package com.example.battleships.models.entities;


import com.example.battleships.models.enums.CategoryNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{


    private CategoryNameEnum name;
    private String description;
    private List<Ship> ships;



    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
