package com.market.supermarket.repositories;

import com.market.supermarket.model.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    @Query("FROM CategoryEntity AS c WHERE c.name = ?1")
    CategoryEntity findCategoryEntityByName(String name);
}
