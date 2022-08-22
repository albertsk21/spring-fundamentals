package com.example.gira.services;

import com.example.gira.domain.dtos.ClassificationDTO;

import java.util.List;

public interface ClassificationService {


    boolean isEmpty();
    void saveAll(List<ClassificationDTO>  classificationsDTO);
    List<ClassificationDTO> getAll();
}
