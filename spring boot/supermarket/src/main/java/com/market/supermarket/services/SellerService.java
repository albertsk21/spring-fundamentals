package com.market.supermarket.services;

import com.market.supermarket.model.dtos.SellerDto;

import java.util.List;

public interface SellerService {

    void saveSeller(SellerDto sellerDto);
    void setManagerToSeller(String managerNames, String sellerNames);
    List<String> findSellersByShopName(String shopName);
}
