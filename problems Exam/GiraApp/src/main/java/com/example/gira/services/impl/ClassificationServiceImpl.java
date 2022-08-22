package com.example.gira.services.impl;

import com.example.gira.domain.dtos.ClassificationDTO;
import com.example.gira.domain.entities.Classification;
import com.example.gira.repositories.ClassificationRepository;
import com.example.gira.services.ClassificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private ClassificationRepository classificationRepository;
    private ModelMapper modelMapper;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmpty() {
        return this.classificationRepository.count() <= 0;
    }

    @Override
    public void saveAll(List<ClassificationDTO> classificationsDTO) {
        this.classificationRepository.saveAll(classificationsDTO
                .stream()
                .map(c  -> this.modelMapper.map(c, Classification.class))
                .collect(Collectors.toList()));
    }

    @Override
    public List<ClassificationDTO> getAll() {
        return this.classificationRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c,ClassificationDTO.class))
                .collect(Collectors.toList());
    }
}
