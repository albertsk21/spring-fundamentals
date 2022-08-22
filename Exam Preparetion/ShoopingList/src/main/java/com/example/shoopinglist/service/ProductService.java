package com.example.shoopinglist.service;

import com.example.shoopinglist.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {



    void save(ProductDTO productDTO);

    List<ProductDTO> getProductsByCategoryName(String category);
    double getSumOfAllProducts();

}
