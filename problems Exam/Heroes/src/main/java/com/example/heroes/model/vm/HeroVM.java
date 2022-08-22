package com.example.heroes.model.vm;

import com.example.heroes.model.enums.OptionEnumName;

public class HeroVM {
    private String name;
    private OptionEnumName optional;
    private int level;

    public HeroVM() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OptionEnumName getOptional() {
        return optional;
    }

    public void setOptional(OptionEnumName optional) {
        this.optional = optional;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
