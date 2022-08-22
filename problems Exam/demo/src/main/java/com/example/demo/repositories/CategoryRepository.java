package com.example.demo.repositories;

import com.example.demo.domain.enums.OptionNameEnum;
import com.example.demo.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("FROM Category c WHERE c.option = ?1")
    Category findCategoryByOption(OptionNameEnum option);
}
