package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u.id FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Optional<UUID> findUserIdByUsernameAndPassword(String username, String password);

    User findUserById(UUID id);

}
