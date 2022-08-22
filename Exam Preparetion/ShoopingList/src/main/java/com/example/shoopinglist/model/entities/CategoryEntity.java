package com.example.shoopinglist.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{


    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;


    public CategoryEntity() {
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
}
