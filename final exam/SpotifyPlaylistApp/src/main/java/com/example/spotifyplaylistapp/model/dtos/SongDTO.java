package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;

import java.util.Date;
import java.util.UUID;

public class SongDTO {


    private UUID id;
    private String performer;
    private String title;
    private int duration;
    private Date date;
    private StyleNameEnum styleNameEnum;




    public SongDTO() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public StyleNameEnum getStyleNameEnum() {
        return styleNameEnum;
    }

    public void setStyleNameEnum(StyleNameEnum styleNameEnum) {
        this.styleNameEnum = styleNameEnum;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }
}
