package com.example.shoopinglist.service.impl;

import com.example.shoopinglist.repositories.CategoryRepository;
import com.example.shoopinglist.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
