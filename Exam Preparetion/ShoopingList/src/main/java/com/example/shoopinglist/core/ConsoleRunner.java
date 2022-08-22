package com.example.shoopinglist.core;

import com.example.shoopinglist.model.entities.CategoryEntity;
import com.example.shoopinglist.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private CategoryService categoryService;

    public ConsoleRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {


        if(this.categoryService.isEmpty()){
            this.addCategories();
        }


    }

    public void addCategories(){
        CategoryEntity category1 = new CategoryEntity();
        category1.setName("Food");
        CategoryEntity category2 = new CategoryEntity();
        category2.setName("Drink");
        CategoryEntity category3 = new CategoryEntity();
        category3.setName("Household");
        CategoryEntity category4 = new CategoryEntity();
        category4.setName("Other");

        this.categoryService.save(category1);
        this.categoryService.save(category2);
        this.categoryService.save(category3);
        this.categoryService.save(category4);
    }

}
