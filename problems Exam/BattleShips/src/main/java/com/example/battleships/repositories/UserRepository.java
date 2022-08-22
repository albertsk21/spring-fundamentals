package com.example.battleships.repositories;

import com.example.battleships.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {


    @Query("FROM User AS u " +
           "WHERE u.username = ?1 AND u.password = ?2")
    User findUserByUsernameAndPassword(String username, String password);


    @Query("SELECT u.id FROM User AS u WHERE u.username = ?1")
    UUID findIdByUsername(String username);

    @Query("FROM User AS u WHERE u.username = ?1")
    UUID findUserIdByUsername(String username);

    @Query("FROM User AS u WHERE u.id = ?1")
    User findUserById(UUID id);

    @Query("FROM User AS u WHERE u.username = ?1")
    User findUserByUsername(String username);


    @Modifying
    @Query("DELETE FROM Ship AS s WHERE s.id = ?1")
    void deleteById(UUID id);
}
