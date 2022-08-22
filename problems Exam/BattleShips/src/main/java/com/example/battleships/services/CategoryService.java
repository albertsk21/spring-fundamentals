package com.example.battleships.services;

import com.example.battleships.models.dtos.CategoryDTO;
import com.example.battleships.models.enums.CategoryNameEnum;

public interface CategoryService {


    void save(CategoryDTO categoryDTO);
    boolean isEmpty();
    CategoryDTO findByName(CategoryNameEnum name);
}
