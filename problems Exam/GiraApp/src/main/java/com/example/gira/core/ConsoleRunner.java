package com.example.gira.core;

import com.example.gira.domain.dtos.ClassificationDTO;
import com.example.gira.domain.entities.Classification;
import com.example.gira.domain.enums.ClassificationNameEnum;
import com.example.gira.services.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ConsoleRunner implements CommandLineRunner {
    private ClassificationService classificationService;

    public ConsoleRunner(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.classificationService.isEmpty()){
            this.addClassifications();
        }



    }


    private void addClassifications(){

        List<ClassificationDTO> classificationsDTO = new ArrayList<>();
        classificationsDTO.add(new ClassificationDTO().setClassificationName(ClassificationNameEnum.BUG));
        classificationsDTO.add(new ClassificationDTO().setClassificationName(ClassificationNameEnum.FEATURE));
        classificationsDTO.add(new ClassificationDTO().setClassificationName(ClassificationNameEnum.OTHER));
        classificationsDTO.add(new ClassificationDTO().setClassificationName(ClassificationNameEnum.SUPPORT));

        this.classificationService.saveAll(classificationsDTO);
    }


}
