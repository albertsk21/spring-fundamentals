package com.market.supermarket.services.impl;

import com.market.supermarket.commons.OutputMessages;
import com.market.supermarket.model.dtos.ProductDto;
import com.market.supermarket.model.entities.CategoryEntity;
import com.market.supermarket.model.entities.ProductEntity;
import com.market.supermarket.repositories.CategoryRepository;
import com.market.supermarket.repositories.ProductRepository;
import com.market.supermarket.repositories.ShopRepository;
import com.market.supermarket.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ShopRepository shopRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        CategoryEntity category  = this.categoryRepository.findCategoryEntityByName(productDto.getCategory());


        ProductEntity productEntity = new ProductEntity()
                .setBestBefore(productDto.getBestBefore())
                .setDescription(productDto.getDescription())
                .setName(productDto.getName())
                .setPrice(productDto.getPrice())
                .setCategory(category);

        this.productRepository.save(productEntity);

    }

    @Override
    public Map<String, Double> getProductsByShopName(String shopName) {

        List<ProductEntity> products = this.productRepository.findProductEntitiesByShopName(shopName);
        Map<String,Double> exportProducts = new LinkedHashMap<>();
        for (ProductEntity productEntity : products) {

            exportProducts.put(productEntity.getName(),productEntity.getPrice());
        }
        return exportProducts;
    }

}
