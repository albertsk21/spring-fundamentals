package com.example.demo.services.impl;

import com.example.demo.domain.dtos.CategoryDTO;
import com.example.demo.domain.model.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void saveCategory(CategoryDTO categoryDTO) {
        this.categoryRepository.save(this.modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public boolean isEmpty() {
        return this.categoryRepository.count() <= 0;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return this.categoryRepository.findAll()
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO convertToCategoryDTO(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setOption(category.getOption());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }
}
