package com.example.gira.repositories;

import com.example.gira.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Query("FROM Task ")
    List<Task> findAll();

    @Query("FROM Task t WHERE t.id = ?1")
    Task findTaskById(UUID id);


    @Modifying
    @Query("DELETE FROM Task u WHERE u.id = ?1")
    void deleteById(UUID id);
}
