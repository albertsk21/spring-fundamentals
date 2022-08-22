package com.example.gira.domain.vm;

import com.example.gira.domain.enums.ClassificationNameEnum;
import com.example.gira.domain.enums.ProgressNameEnum;

import java.util.Date;
import java.util.UUID;

public class TaskVM {

    private UUID id;
    private String name;
    private String description;
    private Date date;
    private ClassificationNameEnum classificationName;
    private ProgressNameEnum progress;
    private String username;

    public TaskVM() {
    }

    public ProgressNameEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressNameEnum progress) {
        this.progress = progress;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClassificationNameEnum getClassificationName() {

        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }
}
