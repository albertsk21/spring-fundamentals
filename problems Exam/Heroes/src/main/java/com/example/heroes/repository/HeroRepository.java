package com.example.heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.heroes.model.entities.Hero;

import java.util.List;
import java.util.UUID;

@Repository
public interface HeroRepository extends JpaRepository<Hero, UUID> {


    List<Hero> findHeroByUserId(UUID id);

    @Modifying
    void deleteById(UUID uuid);


    @Query("FROM Hero u WHERE u.id = ?1")
    Hero findHeroById(UUID id);
}
