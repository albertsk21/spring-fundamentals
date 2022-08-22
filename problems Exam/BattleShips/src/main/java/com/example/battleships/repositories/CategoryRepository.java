package com.example.battleships.repositories;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.User;
import com.example.battleships.models.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("FROM Category AS c WHERE c.name = ?1 ")
    Category findCategoryByName(CategoryNameEnum name);



}
