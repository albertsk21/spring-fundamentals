package com.example.battleships.core;


import com.example.battleships.models.dtos.CategoryDTO;
import com.example.battleships.models.dtos.UserDTO;
import com.example.battleships.models.enums.CategoryNameEnum;
import com.example.battleships.services.CategoryService;
import com.example.battleships.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {


    private CategoryService categoryService;
    private UserService userService;

    public ConsoleRunner(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {

        this.addCategories();

    }
    public void addCategories(){

        if (!this.categoryService.isEmpty()){
            return;
        }

        CategoryDTO categoryCargo = new CategoryDTO();
        categoryCargo.setName(CategoryNameEnum.CARGO);

        CategoryDTO categoryPatrol = new CategoryDTO();
        categoryPatrol.setName(CategoryNameEnum.PATROL);

        CategoryDTO categoryBattle = new CategoryDTO();
        categoryBattle.setName(CategoryNameEnum.BATTLE);


        this.categoryService.save(categoryCargo);
        this.categoryService.save(categoryPatrol);
        this.categoryService.save(categoryBattle);

    }
}
