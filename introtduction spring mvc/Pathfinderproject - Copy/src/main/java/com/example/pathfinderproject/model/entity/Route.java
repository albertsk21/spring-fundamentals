package com.example.pathfinderproject.model.entity;

import com.example.pathfinderproject.model.entity.enums.UserLevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {


    private String description;
    private String gpxCoordinates;
    private UserLevelEnum level;
    private String name;
    private User author;
    private String videoUrl;
    private Set<Picture> pictures;
    private Set<Category> categories;
    private Set<Comment> comments;


    public Route() {
    }



    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    @Enumerated(EnumType.STRING)
    public UserLevelEnum getLevel() {
        return level;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }


    public String getVideoUrl() {
        return videoUrl;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }
    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
