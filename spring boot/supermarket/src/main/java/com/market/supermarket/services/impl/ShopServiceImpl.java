package com.market.supermarket.services.impl;

import com.market.supermarket.model.dtos.ShopDto;
import com.market.supermarket.model.entities.ProductEntity;
import com.market.supermarket.model.entities.ShopEntity;
import com.market.supermarket.model.entities.TownEntity;
import com.market.supermarket.repositories.ProductRepository;
import com.market.supermarket.repositories.ShopRepository;
import com.market.supermarket.repositories.TownRepository;
import com.market.supermarket.services.ShopService;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;
    private TownRepository townRepository;
    private ProductRepository productRepository;
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void saveShop(ShopDto shopDto) {


        TownEntity town = this.townRepository.findTownEntityByName(shopDto.getTown());

        ShopEntity shop = new ShopEntity()
                .setName(shopDto.getName())
                .setAddress(shopDto.getAddress())
                .setTown(town);
        this.shopRepository.save(shop);
    }

    @Override
    public void distributionProduct(String productName, String... shops) {
        ProductEntity productEntity = this.productRepository.findProductEntityByName(productName);

        for (String shopName : shops) {
            ShopEntity shop = this.shopRepository.findShopEntityByName(shopName);
            if(shop != null){
                shop.getProducts().add(productEntity);
                productEntity.getShops().add(shop);
                this.shopRepository.save(shop);

            }
        }
        this.productRepository.save(productEntity);
    }
}
