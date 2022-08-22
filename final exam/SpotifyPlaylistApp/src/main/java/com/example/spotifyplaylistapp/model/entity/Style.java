package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity {


    private StyleNameEnum styleName;
    private String description;
    private List<Song> songs;

    @Column(name = "style_name", unique = true)
    @Enumerated(EnumType.STRING)
    public StyleNameEnum getStyleName() {
        return styleName;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @OneToMany(mappedBy = "style", fetch = FetchType.EAGER)
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
