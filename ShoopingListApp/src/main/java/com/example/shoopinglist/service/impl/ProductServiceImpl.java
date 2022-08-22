package com.example.shoopinglist.service.impl;

import com.example.shoopinglist.repositories.ProductRepository;
import com.example.shoopinglist.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
