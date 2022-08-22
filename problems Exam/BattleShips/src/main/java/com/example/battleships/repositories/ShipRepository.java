package com.example.battleships.repositories;

import com.example.battleships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShipRepository extends JpaRepository<Ship, UUID> {


    @Query("FROM Ship AS s " +
           "JOIN s.user AS u " +
           "WHERE u.id = ?1")
    List<Ship> findShipsByUserId(UUID id);



    @Query("FROM Ship AS s " +
            "JOIN s.user AS u " +
            "WHERE u.id != ?1")
    List<Ship> findShipsByDifferentUserId(UUID id);

    @Query("FROM Ship AS s WHERE s.name = ?1")
    Ship findShipByName(String name);


    @Modifying
    @Transactional
    @Query("DELETE FROM Ship AS s WHERE s.id = ?1")
    void deleteById(UUID id);
}
