package com.market.supermarket.commandApp;

import com.market.supermarket.commandApp.abstracsClasses.ConcreteCommander;
import com.market.supermarket.commons.OutputMessages;
import com.market.supermarket.model.dtos.*;
import com.market.supermarket.services.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommanderApplication extends ConcreteCommander {

    public CommanderApplication() {
        super();
    }

    @Override
    public String addCategory(CategoryService categoryService) throws IOException {
        System.out.println(OutputMessages.ENTER_CATEGORY_NAME);
        String categoryName = super.getReader().readLine();
        CategoryDto categoryDto = new CategoryDto(categoryName);
        categoryService.saveCategory(categoryDto);

        String entityName = this.getPrefixNameClassDto(categoryDto.getClass());
        return String.format(OutputMessages.ADDED_FORMAT,entityName);
    }

    @Override
    public String addTown(TownService townService) throws IOException {
        System.out.println(OutputMessages.ENTER_TOWN_NAME);
        String townName = super.getReader().readLine();
        TownDto townDto = new TownDto();
        townDto.setName(townName);
        townService.saveTown(townDto);
        String entityName = this.getPrefixNameClassDto(townDto.getClass());
        return String.format(OutputMessages.ADDED_FORMAT,entityName );

    }

    @Override
    public String addShop(ShopService shopService) throws IOException {
        System.out.println(OutputMessages.ENTER_SHOP_FORMAT);

        String[] details = super.getReader().readLine().split(" ");

        ShopDto shopDto = new ShopDto()
                .setName(details[0])
                .setAddress(details[1])
                .setTown(details[2]);
        shopService.saveShop(shopDto);

        String entityName = this.getPrefixNameClassDto(shopDto.getClass());
        return String.format(OutputMessages.ADDED_FORMAT,entityName);
    }

    @Override
    public String addSeller(SellerService sellerService) throws IOException {
        System.out.println(OutputMessages.ENTER_SELLER_FORMAT);
        String[] detailsSeller = super.getReader().readLine().split(" ");

        SellerDto sellerDto = new SellerDto()
                .setFirstName(detailsSeller[0])
                .setLastName(detailsSeller[1])
                .setAge(Integer.parseInt(detailsSeller[2]))
                .setSalary(Double.parseDouble(detailsSeller[3]))
                .setShopName(detailsSeller[4]);

        sellerService.saveSeller(sellerDto);

        String entityName = this.getPrefixNameClassDto(sellerDto.getClass());
        return String.format(OutputMessages.ADDED_FORMAT,entityName);
    }

    @Override
    public String addProduct(ProductService productService) throws IOException {
        System.out.println(OutputMessages.ENTER_PRODUCT_FORMAT);
        String[] detailsProduct =super.getReader().readLine().split(" ");

        ProductDto productDto = new ProductDto()
                .setName(detailsProduct[0])
                .setPrice(Double.parseDouble(detailsProduct[1]))
                .setBestBefore(detailsProduct[2])
                .setCategory(detailsProduct[3]);


        productService.saveProduct(productDto);


        String entityName = this.getPrefixNameClassDto(productDto.getClass());
        return String.format(OutputMessages.ADDED_FORMAT,entityName);
    }

    @Override
    public String setSellerToManager(SellerService sellerService) throws IOException {
        System.out.println(OutputMessages.ENTER_SELLER_FIRSTNAME_LASTNAME);
        String sellerNames = super.getReader().readLine();
        System.out.println(OutputMessages.ENTER_MANAGER_FIRSTNAME_LASTNAME);
        String managerNames = super.getReader().readLine();
        sellerService.setManagerToSeller(managerNames,sellerNames);

        String entityName = "manager";
        return String.format(OutputMessages.ADDED_FORMAT,entityName);
    }

    @Override
    public String distributionProductToShops(ShopService shopService) throws IOException {

        System.out.println(OutputMessages.ENTER_PRODUCT_NAME);
        String productName = super.getReader().readLine();
        System.out.println(OutputMessages.ENTER_DISTRIBUTION_SHOPS);
        String[] shopsName = super.getReader().readLine().split(" ");

        shopService.distributionProduct(productName,shopsName);

        return OutputMessages.ADDED_PRODUCT_DISTRIBUTION;
    }

    @Override
    public String showAllSellersByShopName(SellerService sellerService) throws IOException {
        System.out.println(OutputMessages.ENTER_SHOP_NAME);


        String shopName =  super.getReader().readLine();

        List<String> sellers = sellerService.findSellersByShopName(shopName);

        StringBuilder output = new StringBuilder();


        for (int i = 0; i <sellers.size() ; i++) {
            output.append(sellers.get(i));
            if(i < sellers.size() - 1){
                output.append("\n");
            }
        }

        return output.toString();
    }

    @Override
    public String showProductsByShopName(ProductService productService) throws IOException {
        System.out.println(OutputMessages.ENTER_SHOP_NAME);
        String shop = super.getReader().readLine();

        Map<String,Double> products = productService.getProductsByShopName(shop);

        StringBuilder output = new StringBuilder();
        int counter = 0;
        for (String key  : products.keySet()) {
            output.append(String.format(OutputMessages.PRODUCT_FORMAT,key,products.get(key)));
            if(counter < products.size() - 1) {
                output.append("\n");
            }
        }

        return output.toString();
    }

    @Override
    public String closeProgram() {
        return OutputMessages.CLOSE_PROGRAM;
    }

}
