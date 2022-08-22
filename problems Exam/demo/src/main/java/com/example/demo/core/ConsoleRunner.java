package com.example.demo.core;

import com.example.demo.domain.dtos.CategoryDTO;
import com.example.demo.domain.enums.OptionNameEnum;
import com.example.demo.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private CategoryService categoryService;

    public ConsoleRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args)  {


        if(this.categoryService.isEmpty()){
            this.addCategories();
        }


    }

    public void addCategories(){

        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setOption(OptionNameEnum.DENIM);
        CategoryDTO categoryDTO2 = new CategoryDTO();
        categoryDTO2.setOption(OptionNameEnum.JACKET);
        CategoryDTO categoryDTO3 = new CategoryDTO();
        categoryDTO3.setOption(OptionNameEnum.SHIRT);
        CategoryDTO categoryDTO4 = new CategoryDTO();
        categoryDTO4.setOption(OptionNameEnum.SHORTS);;


        this.categoryService.saveCategory(categoryDTO1);
        this.categoryService.saveCategory(categoryDTO2);
        this.categoryService.saveCategory(categoryDTO3);
        this.categoryService.saveCategory(categoryDTO4);





    }
}
