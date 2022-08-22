package com.example.gira.domain.entities;

import com.example.gira.domain.enums.ClassificationNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{


    private ClassificationNameEnum classificationName;
    private String description;
    private List<Task> tasks;

    @Column(name = "classification_name", unique = true)
    @Enumerated(EnumType.STRING)
    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }


    @OneToMany(mappedBy = "classification", fetch = FetchType.EAGER)
    public List<Task> getTasks() {
        return tasks;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
