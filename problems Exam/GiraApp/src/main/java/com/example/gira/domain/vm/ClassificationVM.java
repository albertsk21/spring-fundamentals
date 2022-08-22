package com.example.gira.domain.vm;

import com.example.gira.domain.enums.ClassificationNameEnum;

public class ClassificationVM {

    private ClassificationNameEnum classificationName;


    public ClassificationVM() {
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }
}
