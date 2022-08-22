package com.example.gira.domain.dtos;

import com.example.gira.domain.entities.Classification;
import com.example.gira.domain.enums.ClassificationNameEnum;
import com.example.gira.domain.enums.ProgressNameEnum;

import java.util.Date;
import java.util.UUID;

public class TaskDTO {

    private UUID id;
    private String name;
    private String description;
    private ProgressNameEnum progress;
    private Date date;
    private ClassificationNameEnum classificationName;
    private String username;

    public TaskDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProgressNameEnum getProgress() {
        return progress;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProgress(ProgressNameEnum progress) {
        this.progress = progress;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
