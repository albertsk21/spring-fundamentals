package bg.softuni.project.linkedout.service;

import bg.softuni.project.linkedout.model.dto.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface CompanyService {


    void save(CompanyDTO companyDTO);
    List<CompanyDTO> getAll();
    CompanyDTO findById(String id);
    void deleteById(String id);

}
