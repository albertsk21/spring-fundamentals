package com.example.pathfinderproject.model.service;


import com.example.pathfinderproject.model.entity.Picture;
import com.example.pathfinderproject.model.entity.User;
import com.example.pathfinderproject.model.entity.enums.CategoryNameEnum;
import com.example.pathfinderproject.model.entity.enums.UserLevelEnum;

import java.util.Set;

public class RouteServiceModel {
    private Long id;
    private String gpxCoordinates;
    private String description;
    private String name;
    private User author;
    private UserLevelEnum level;
    private String videoUrl;
    private Set<Picture> pictures;
    private Set<CategoryNameEnum> categories;

    public RouteServiceModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public UserLevelEnum getLevel() {
        return level;
    }

    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public User getAuthor() {
        return author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }
}
