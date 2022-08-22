package bg.softuni.mvc.mvcApplication.repositories;

import bg.softuni.mvc.mvcApplication.models.entities.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<CatEntity,Long> {


    @Query("FROM CatEntity ")
    List<CatEntity> findAll();

    @Query("FROM CatEntity AS c " +
           "WHERE c.id = ?1")
    CatEntity findCatEntityById(Long id);




}

