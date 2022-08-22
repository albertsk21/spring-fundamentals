package com.market.supermarket.services;

import com.market.supermarket.model.dtos.ShopDto;

public interface ShopService {

    void saveShop(ShopDto shopDto);
    void distributionProduct(String productName, String... shops);
}
