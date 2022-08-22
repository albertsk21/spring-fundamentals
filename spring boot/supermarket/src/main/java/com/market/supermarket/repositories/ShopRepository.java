package com.market.supermarket.repositories;

import com.market.supermarket.model.entities.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Long> {


    @Query("FROM ShopEntity AS s WHERE s.name = ?1")
    ShopEntity findShopEntityByName(String name);
}
