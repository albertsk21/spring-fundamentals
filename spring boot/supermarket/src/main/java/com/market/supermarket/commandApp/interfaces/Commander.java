package com.market.supermarket.commandApp.interfaces;

import com.market.supermarket.services.*;

import java.io.IOException;

public interface Commander {

    String addCategory(CategoryService categoryService) throws IOException;
    String addTown(TownService townService) throws IOException;
    String addShop(ShopService shopService) throws IOException;
    String addSeller(SellerService sellerService) throws IOException;
    String addProduct(ProductService productService) throws IOException;
    String setSellerToManager(SellerService sellerService) throws IOException;
    String distributionProductToShops(ShopService shopService) throws IOException;
    String showAllSellersByShopName(SellerService sellerService) throws IOException;
    String showProductsByShopName(ProductService productService) throws IOException;
    String closeProgram();

}
