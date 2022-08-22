package com.example.demo.repositories;

import com.example.demo.domain.model.Item;
import com.example.demo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u.id FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Optional<UUID> findUserIdByUsernameAndPassword(String username, String password);

    @Query("FROM User u WHERE u.id = ?1")
    User findUserById(UUID id);



}
