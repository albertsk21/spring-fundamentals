package com.example.spotifyplaylistapp.model.bm;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.util.annotations.NotInTheFuture;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class SongBM {


    @Size(min = 3, max = 20, message = "Performer name length must be between 3 and 20 characters (inclusive of 3 and 20).")
    private String performer;
    @Size(min = 2, max = 20,message = "Title length must be between 2 and 20 characters (inclusive of 2 and 20).")
    private String title;
    @NotInTheFuture(message = "The Date that cannot be in the future!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    @Positive(message = "The duration must be a positive number!")
    private int duration;
    @NotNull(message = "You must select a style!")
    private StyleNameEnum style;


    public SongBM() {
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


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public StyleNameEnum getStyle() {
        return style;
    }

    public void setStyle(StyleNameEnum style) {
        this.style = style;
    }
}
