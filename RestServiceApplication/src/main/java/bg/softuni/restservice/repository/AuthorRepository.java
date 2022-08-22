package bg.softuni.restservice.repository;

import bg.softuni.restservice.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

    @Query("FROM AuthorEntity AS a WHERE a.name = ?1")
    Optional<AuthorEntity> findByName(String name);
}
