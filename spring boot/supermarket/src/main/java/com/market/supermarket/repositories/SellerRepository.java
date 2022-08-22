package com.market.supermarket.repositories;

import com.market.supermarket.model.entities.SellerEntity;
import com.market.supermarket.services.SellerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity,Long> {


    @Query("FROM SellerEntity AS s WHERE s.firstName = ?1 AND s.lastName = ?2")
    SellerEntity findSellerEntityByFirstNameAndLastName(String firstName, String lastName);


    @Query("FROM SellerEntity AS s " +
            "JOIN s.shop AS so " +
            "WHERE so.name = ?1")
    List<SellerEntity> findSellerEntitiesByShopName(String shopName);

}
