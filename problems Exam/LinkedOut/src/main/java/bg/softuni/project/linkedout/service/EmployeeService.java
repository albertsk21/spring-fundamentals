package bg.softuni.project.linkedout.service;

import bg.softuni.project.linkedout.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {


    void save(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAll();
    EmployeeDTO findById(String id);
    void deleteById(String id);
}
