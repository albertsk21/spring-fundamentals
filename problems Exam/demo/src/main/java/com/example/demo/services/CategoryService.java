package com.example.demo.services;

import com.example.demo.domain.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void saveCategory(CategoryDTO categoryDTO);
    boolean isEmpty();
    List<CategoryDTO> getAll();
}
