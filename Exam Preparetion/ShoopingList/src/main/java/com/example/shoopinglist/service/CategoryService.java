package com.example.shoopinglist.service;

import com.example.shoopinglist.model.dto.CategoryDTO;
import com.example.shoopinglist.model.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    boolean isEmpty();
    void save(CategoryEntity category);
    List<CategoryDTO> getAll();
}
