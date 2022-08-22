package com.example.shoopinglist.service.impl;

import com.example.shoopinglist.model.dto.ProductDTO;
import com.example.shoopinglist.model.entities.CategoryEntity;
import com.example.shoopinglist.model.entities.ProductEntity;
import com.example.shoopinglist.repositories.CategoryRepository;
import com.example.shoopinglist.repositories.ProductRepository;
import com.example.shoopinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void save(ProductDTO productDTO) {
        CategoryEntity category = this.categoryRepository.findCategoryEntityByName(productDTO.getCategory());
        ProductEntity productEntity = this.modelMapper.map(productDTO,ProductEntity.class);
        productEntity.setId(UUID.randomUUID().toString());
        productEntity.setCategory(category);
        productEntity.setExpiration(productDTO.getBefore());
        this.productRepository.save(productEntity);
    }


    @Override
    public List<ProductDTO> getProductsByCategoryName(String category) {

        return this.productRepository.findProductEntitiesByCategoryName(category)
                .stream()
                .map(c -> this.modelMapper.map(c,ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public double getSumOfAllProducts() {

        double sum = this.productRepository.getSumOfAllProducts().orElse(Double.parseDouble("0"));
        return sum;
    }
}
