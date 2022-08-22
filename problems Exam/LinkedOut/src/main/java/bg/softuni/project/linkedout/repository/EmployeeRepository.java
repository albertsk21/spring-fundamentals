package bg.softuni.project.linkedout.repository;

import bg.softuni.project.linkedout.model.entities.CompanyEntity;
import bg.softuni.project.linkedout.model.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {

    @Query("FROM EmployeeEntity ")
    List<EmployeeEntity> findAllEmployees();

    @Query("FROM EmployeeEntity AS e WHERE e.id = ?1")
    EmployeeEntity findEmployeeEntityById(String id);


    @Query("FROM EmployeeEntity AS e " +
           "JOIN e.company AS c " +
           "WHERE c.name = ?1")
    List<EmployeeEntity> findEmployeeEntityByCompanyName(String name);
}
