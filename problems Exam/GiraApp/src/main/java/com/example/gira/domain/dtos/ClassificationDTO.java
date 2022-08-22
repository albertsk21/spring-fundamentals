package com.example.gira.domain.dtos;

import com.example.gira.domain.enums.ClassificationNameEnum;

public class ClassificationDTO {
    private ClassificationNameEnum classificationName;
    private String description;

    public ClassificationDTO() {
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public ClassificationDTO setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassificationDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
