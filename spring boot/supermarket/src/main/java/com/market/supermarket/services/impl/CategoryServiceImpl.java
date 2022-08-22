package com.market.supermarket.services.impl;

import com.market.supermarket.commons.OutputMessages;
import com.market.supermarket.model.dtos.CategoryDto;
import com.market.supermarket.model.entities.CategoryEntity;
import com.market.supermarket.repositories.CategoryRepository;
import com.market.supermarket.services.CategoryService;
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
    public void  saveCategory(CategoryDto categoryDto) {
          CategoryEntity category = this.modelMapper.map(categoryDto,CategoryEntity.class);
          this.categoryRepository.save(category);

    }
}
