package com.market.supermarket.repositories;

import com.market.supermarket.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("FROM ProductEntity as p WHERE p.name = ?1")
    ProductEntity findProductEntityByName(String name);

    @Query("FROM ProductEntity AS p " +
           "JOIN p.shops AS s " +
           "WHERE s.name = ?1")
    List<ProductEntity> findProductEntitiesByShopName(String shopName);
}
