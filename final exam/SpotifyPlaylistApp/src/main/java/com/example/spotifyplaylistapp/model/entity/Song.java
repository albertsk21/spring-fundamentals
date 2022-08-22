package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {


    private String performer;
    private String title;
    private int duration;
    private Date date;
    private User user;
    private Style style;
    private List<User> users;

    public Song() {
    }

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    //    TODO Style

    @Column(unique = true, nullable = false)
    public String getPerformer() {
        return performer;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(nullable = false)
    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "style_id")
    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }


    public Date getDate() {
        return date;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setDate(Date date) {
        this.date = date;
    }
}
