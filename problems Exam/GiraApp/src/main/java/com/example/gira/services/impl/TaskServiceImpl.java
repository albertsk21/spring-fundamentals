package com.example.gira.services.impl;

import com.example.gira.domain.entities.Classification;
import com.example.gira.domain.entities.Task;
import com.example.gira.domain.entities.User;
import com.example.gira.domain.dtos.TaskDTO;
import com.example.gira.domain.enums.ProgressNameEnum;
import com.example.gira.repositories.ClassificationRepository;
import com.example.gira.repositories.TaskRepository;
import com.example.gira.repositories.UserRepository;
import com.example.gira.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private ClassificationRepository classificationRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, UserRepository userRepository, ClassificationRepository classificationRepository) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void saveTask(TaskDTO taskDTO, UUID userId) {

        User user = this.userRepository.findUserById(userId);
        Classification classification = this.classificationRepository.findClassificationByClassificationName(taskDTO.getClassificationName());
        Task task = this.modelMapper.map(taskDTO,Task.class);

        task.setClassification(classification);
        if(taskDTO.getProgress() == null){
            task.setProgress(ProgressNameEnum.OPEN);
        }else{
            task.setProgress(taskDTO.getProgress());
        }

        task.setUser(user);
        this.taskRepository.save(task);

    }

    @Override
    public List<TaskDTO> getAll() {
        return this.taskRepository.findAll()
                .stream()
                .map(t -> {
                    TaskDTO taskDTO = this.modelMapper.map(t,TaskDTO.class);
                    taskDTO.setClassificationName(t.getClassification().getClassificationName());
                    taskDTO.setUsername(t.getUser().getUsername());
                    return taskDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(UUID id) {
        return this.modelMapper.map(this.taskRepository.findTaskById(id),TaskDTO.class);
    }

    @Override
    public void deleteById(UUID id) {
        this.taskRepository.deleteById(id);
    }

    public List<TaskDTO> findAll(){
        return this.taskRepository.findAll()
                .stream()
                .map(t -> this.modelMapper.map(t,TaskDTO.class))
                .collect(Collectors.toList());
    }
}
