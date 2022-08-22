package com.example.gira.services;

import com.example.gira.domain.dtos.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    void saveTask(TaskDTO taskDTO, UUID userId);
    List<TaskDTO> getAll();
    TaskDTO findById(UUID id);
    void deleteById(UUID id);
}
