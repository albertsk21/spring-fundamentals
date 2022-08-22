package bg.softuni.userproject.repository;

import bg.softuni.userproject.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    @Query("FROM UserEntity AS u WHERE u.id = ?1")
    UserEntity findUserById(Long id);

    @Query("FROM UserEntity")
    List<UserEntity> findAll();
}
