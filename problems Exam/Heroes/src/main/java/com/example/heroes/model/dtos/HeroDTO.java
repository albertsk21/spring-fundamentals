package com.example.heroes.model.dtos;

import com.example.heroes.model.enums.OptionEnumName;

import java.util.UUID;

public class HeroDTO {
    private UUID id;
    private String name;
    private OptionEnumName optional;
    private int level;

    public HeroDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOptional(OptionEnumName optional) {
        this.optional = optional;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public OptionEnumName getOptional() {
        return optional;
    }

    public int getLevel() {
        return level;
    }
}
