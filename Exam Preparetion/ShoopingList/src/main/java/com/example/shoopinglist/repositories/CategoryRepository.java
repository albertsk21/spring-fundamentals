package com.example.shoopinglist.repositories;

import com.example.shoopinglist.model.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,String> {

    @Query("FROM CategoryEntity ")
    List<CategoryEntity> findAll();

    @Query("FROM CategoryEntity AS c WHERE c.name = ?1")
    CategoryEntity findCategoryEntityByName(String name);
}
