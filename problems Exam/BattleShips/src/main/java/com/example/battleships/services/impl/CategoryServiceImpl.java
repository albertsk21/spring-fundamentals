package com.example.battleships.services.impl;

import com.example.battleships.models.dtos.CategoryDTO;
import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.CategoryNameEnum;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        this.categoryRepository.save(this.modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public boolean isEmpty() {
        return this.categoryRepository.count() <= 0;
    }

    @Override
    public CategoryDTO findByName(CategoryNameEnum name) {
        return this.modelMapper.map(this.categoryRepository.findCategoryByName(name),CategoryDTO.class);
    }
}
