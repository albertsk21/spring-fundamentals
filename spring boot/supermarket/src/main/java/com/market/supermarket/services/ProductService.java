package com.market.supermarket.services;

import com.market.supermarket.model.dtos.ProductDto;

import java.util.Map;

public interface ProductService {

    void saveProduct(ProductDto productDto);
    Map<String, Double> getProductsByShopName(String shopName);
}
