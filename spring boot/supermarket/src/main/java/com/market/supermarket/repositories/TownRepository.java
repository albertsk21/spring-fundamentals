package com.market.supermarket.repositories;


import com.market.supermarket.model.entities.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<TownEntity,Long> {


    @Query("FROM TownEntity AS t WHERE t.name = ?1")
    TownEntity findTownEntityByName(String name);

}
