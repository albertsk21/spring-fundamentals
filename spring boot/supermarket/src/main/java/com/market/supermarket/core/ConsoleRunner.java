package com.market.supermarket.core;


import com.market.supermarket.commandApp.CommanderApplication;
import com.market.supermarket.commandApp.interfaces.Commander;
import com.market.supermarket.commandApp.interfaces.Engine;
import com.market.supermarket.commandApp.EngineCommander;
import com.market.supermarket.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private CategoryService categoryService;
    private TownService townService;
    private ShopService shopService;
    private SellerService sellerService;
    private ProductService productService;

    public ConsoleRunner(CategoryService categoryService, TownService townService, ShopService shopService, SellerService sellerService, ProductService productService) {
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
        this.sellerService = sellerService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws IOException {


        Commander commander = new CommanderApplication();
        Engine engine = new EngineCommander(
                commander,
                this.sellerService,
                this.productService,
                this.shopService,
                this.categoryService,
                this.townService
        );

        engine.run();

    }
}
