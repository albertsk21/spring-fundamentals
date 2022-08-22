package com.example.demo.domain.vm;

import com.example.demo.domain.enums.OptionNameEnum;

public class CategoryVM {


    private OptionNameEnum option;

    public CategoryVM() {
    }

    public OptionNameEnum getOption() {
        return option;
    }

    public void setOption(OptionNameEnum option) {
        this.option = option;
    }
}
