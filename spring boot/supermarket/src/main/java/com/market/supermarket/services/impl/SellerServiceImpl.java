package com.market.supermarket.services.impl;

import com.market.supermarket.commons.OutputMessages;
import com.market.supermarket.model.dtos.SellerDto;
import com.market.supermarket.model.entities.SellerEntity;
import com.market.supermarket.model.entities.ShopEntity;
import com.market.supermarket.repositories.SellerRepository;
import com.market.supermarket.repositories.ShopRepository;
import com.market.supermarket.services.SellerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;
    private ShopRepository shopRepository;
    public SellerServiceImpl(SellerRepository sellerRepository, ShopRepository shopRepository) {
        this.sellerRepository = sellerRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public void saveSeller(SellerDto sellerDto) {

        ShopEntity shop = this.shopRepository.findShopEntityByName(sellerDto.getShopName());

        SellerEntity sellerEntity = new SellerEntity()
                .setFirstName(sellerDto.getFirstName())
                .setLastName(sellerDto.getLastName())
                .setAge(sellerDto.getAge())
                .setSalary(sellerDto.getSalary())
                .setShop(shop);

        this.sellerRepository.save(sellerEntity);

    }

    @Override
    public void setManagerToSeller(String managerNames, String sellerNames) {


        String[] detailsManagerNames = managerNames.split(" ");
        String[] detailsSellerNames = sellerNames.split(" ");
        SellerEntity manager  = this.sellerRepository.findSellerEntityByFirstNameAndLastName(detailsManagerNames[0],detailsManagerNames[1]);
        SellerEntity seller  = this.sellerRepository.findSellerEntityByFirstNameAndLastName(detailsSellerNames[0],detailsSellerNames[1]);
        seller.setManager(manager);

        this.sellerRepository.save(seller);

    }

    @Override
    public List<String> findSellersByShopName(String shopName) {

        List<SellerEntity> sellers = this.sellerRepository.findSellerEntitiesByShopName(shopName);

        List<String> exportSellers = new ArrayList<>();

        for (SellerEntity sellerEntity : sellers) {
            exportSellers.add(sellerEntity.getFirstName() + " " + sellerEntity.getLastName());
        }
        return exportSellers;
    }
}
