package com.example.gira.domain.entities;

import com.example.gira.domain.enums.ProgressNameEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {


    private String name;
    private String description;
    private ProgressNameEnum progress;
    private Date date;
    private Classification classification;
    private User user;


    @Column(unique = true)
    public String getName() {
        return name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }


    @Enumerated(EnumType.STRING)
    public ProgressNameEnum getProgress() {
        return progress;
    }

    public Date getDate() {
        return date;
    }


    @ManyToOne
    @JoinColumn(name = "classification_id")
    public Classification getClassification() {
        return classification;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
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

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
