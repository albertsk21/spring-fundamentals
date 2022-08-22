package com.market.supermarket.commandApp.abstracsClasses;



import com.market.supermarket.commandApp.interfaces.Engine;
import com.market.supermarket.services.*;

public abstract class ConcreteEngine implements Engine {

    private SellerService sellerService;
    private ProductService productService;
    private ShopService shopService;
    private CategoryService categoryService;
    private TownService townService;

    public ConcreteEngine(SellerService sellerService, ProductService productService, ShopService shopService, CategoryService categoryService, TownService townService) {
        this.sellerService = sellerService;
        this.productService = productService;
        this.shopService = shopService;
        this.categoryService = categoryService;
        this.townService = townService;
    }



    public SellerService getSellerService() {
        return sellerService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public TownService getTownService() {
        return townService;
    }
}
