package com.example.heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.heroes.model.entities.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u.id FROM User AS u WHERE u.username = ?1 AND u.password = ?2")
    Optional<UUID> findIdByUsernameAndPassword(String username, String password);

    @Query("FROM User AS u WHERE u.id = ?1")
    User findUserById(UUID id);

}
