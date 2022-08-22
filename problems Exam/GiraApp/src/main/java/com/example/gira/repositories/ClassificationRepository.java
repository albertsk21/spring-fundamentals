package com.example.gira.repositories;

import com.example.gira.domain.entities.Classification;
import com.example.gira.domain.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, UUID> {

    @Query("FROM Classification c WHERE c.classificationName = ?1")
    Classification findClassificationByClassificationName(ClassificationNameEnum classificationName);
}
