package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;

public class StyleDTO {
    private StyleNameEnum styleName;
    private String description;

    public StyleDTO() {
    }

    public StyleNameEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
