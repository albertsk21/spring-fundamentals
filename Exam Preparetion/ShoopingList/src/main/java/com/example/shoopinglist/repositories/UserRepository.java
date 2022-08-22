package com.example.shoopinglist.repositories;


import com.example.shoopinglist.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {


    @Query("FROM UserEntity AS u WHERE u.username = ?1 AND u.password = ?2")
    UserEntity findUserEntityByUsernameAndPassword(String username, String password);

    @Query("SELECT u.id FROM UserEntity AS u WHERE u.username = ?1")
    String findIdByUsername(String username);
}
