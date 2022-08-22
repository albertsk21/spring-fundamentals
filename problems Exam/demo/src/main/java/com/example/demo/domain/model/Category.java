package com.example.demo.domain.model;

import com.example.demo.domain.enums.OptionNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private OptionNameEnum option;
    private String description;
    private List<Item> items;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "\"option\"")
    public OptionNameEnum getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }


    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    public List<Item> getItems() {
        return items;
    }

    public void setOption(OptionNameEnum option) {
        this.option = option;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
