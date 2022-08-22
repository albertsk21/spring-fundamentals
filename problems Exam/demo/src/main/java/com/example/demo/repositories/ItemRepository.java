package com.example.demo.repositories;

import com.example.demo.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Query("FROM Item ")
    List<Item> findAll();

    @Query("FROM Item i WHERE i.id = ?1")
    Item findItemById(UUID id);


    @Modifying
    @Query("DELETE FROM Item i WHERE i.id = ?1")
    void deleteById(UUID id);
}
