package com.example.shoopinglist.service.impl;


import com.example.shoopinglist.model.dto.CategoryDTO;
import com.example.shoopinglist.model.entities.CategoryEntity;
import com.example.shoopinglist.repositories.CategoryRepository;
import com.example.shoopinglist.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmpty() {
        return this.categoryRepository.count() <= 0;
    }

    @Override
    public void save(CategoryEntity category) {
        category.setId(UUID.randomUUID().toString());
        this.categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return this.categoryRepository.findAll()
                .stream()
                .map(category -> this.modelMapper.map(category,CategoryDTO.class))
                .collect(Collectors.toList());
    }
}
