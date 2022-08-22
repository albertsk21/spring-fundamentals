package com.example.shoopinglist.repositories;

import com.example.shoopinglist.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {

    @Query("FROM ProductEntity AS p " +
           "JOIN p.category AS c " +
           "WHERE c.name = ?1 " )
    List<ProductEntity> findProductEntitiesByCategoryName(String name);



    @Query("SELECT SUM(p.price) AS sum FROM ProductEntity AS p")
    Optional<Double> getSumOfAllProducts();
}