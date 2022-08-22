package bg.softuni.project.linkedout.repository;

import bg.softuni.project.linkedout.model.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,String> {

    @Query("FROM CompanyEntity AS c WHERE c.name = ?1")
    CompanyEntity findCompanyEntityByName(String name);

    @Query("FROM CompanyEntity")
    List<CompanyEntity> findAllCompanies();

    @Query("FROM CompanyEntity AS c WHERE c.id = ?1")
    CompanyEntity findCompanyEntityById(String id);
}
