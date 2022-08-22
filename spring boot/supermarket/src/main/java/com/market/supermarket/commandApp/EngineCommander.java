package com.market.supermarket.commandApp;

import com.market.supermarket.commandApp.interfaces.Commander;
import com.market.supermarket.commandApp.abstracsClasses.ConcreteEngine;
import com.market.supermarket.commons.ExceptionMessages;
import com.market.supermarket.commons.OutputMessages;
import com.market.supermarket.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineCommander extends ConcreteEngine {

    private Commander command;

    public EngineCommander(Commander commander,
                           SellerService sellerService,
                           ProductService productService,
                           ShopService shopService,
                           CategoryService categoryService,
                           TownService townService
    ) {
        super(sellerService, productService, shopService, categoryService, townService);
        this.command = commander;
    }

    @Override
    public void run() throws IOException {
        System.out.println(OutputMessages.START_APPLICATION);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int insertNumber = Integer.parseInt(reader.readLine());

        String result = "";
        boolean stopProgram = false;
        while (true){

            try {
                if(insertNumber == 10){
                    stopProgram = true;
                }
                result = this.runCommand(insertNumber);

            }catch (IllegalArgumentException ex){
                result = ex.getMessage();
            }

            System.out.println(result);
            if (stopProgram){
                break;
            }
            insertNumber = Integer.parseInt(reader.readLine());
        }
    }

    public Commander getCommand() {
        return command;
    }

    private String runCommand(int number) throws IOException {
        switch (number){
            case 1:
                return this.getCommand().addCategory(super.getCategoryService());
            case 2:
                return this.getCommand().addTown(super.getTownService());
            case 3:
                return this.getCommand().addShop(super.getShopService());
            case 4:
                return this.getCommand().addSeller(super.getSellerService());
            case 5:
                return this.getCommand().addProduct(super.getProductService());
            case 6:
                return this.getCommand().setSellerToManager(super.getSellerService());
            case 7:
                return this.getCommand().distributionProductToShops(super.getShopService());
            case 8:
                return this.getCommand().showAllSellersByShopName(super.getSellerService());
            case 9:
                return this.getCommand().showProductsByShopName(super.getProductService());
            case 10:
                return this.getCommand().closeProgram();
            default:
                throw new IllegalArgumentException(ExceptionMessages.COMMAND_NOT_FOUND);
        }
    }
}
