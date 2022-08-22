package com.example.gira.domain.bm;

import com.example.gira.domain.enums.ClassificationNameEnum;
import com.example.gira.util.validation.annotations.NotInThePast;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class TaskBM {
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters characters!")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotInThePast(message = "The date cannot be in the past!")
    private Date date;
    @NotNull(message = "Classification cannot be null!")
    private ClassificationNameEnum classificationName;


    public TaskBM() {
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

}
