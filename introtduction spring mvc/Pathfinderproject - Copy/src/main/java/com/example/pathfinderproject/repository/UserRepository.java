package com.example.pathfinderproject.repository;

import com.example.pathfinderproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    @Query("FROM User AS c WHERE c.username = ?1 AND c.password = ?2")
    User findByUsernameAndPassword(String username, String password);

    @Query("FROM User AS c WHERE c.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("FROM User AS c WHERE c.id = ?1")
    User findUserById(Long id);

}
