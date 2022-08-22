package bg.softuni.project.linkedout.service.impl;


import bg.softuni.project.linkedout.model.dto.EmployeeDTO;
import bg.softuni.project.linkedout.model.entities.CompanyEntity;
import bg.softuni.project.linkedout.model.entities.EmployeeEntity;
import bg.softuni.project.linkedout.repository.CompanyRepository;
import bg.softuni.project.linkedout.repository.EmployeeRepository;
import bg.softuni.project.linkedout.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private CompanyRepository companyRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {

        CompanyEntity company =  this.companyRepository.findCompanyEntityByName(employeeDTO.getCompanyName());
        if(company == null){
            throw new IllegalArgumentException("Company not found");
        }
        EmployeeEntity employee = this.modelMapper.map(employeeDTO,EmployeeEntity.class);
        employee.setCompany(company);
        employee.setId(UUID.randomUUID().toString());
        this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return this.employeeRepository
                .findAllEmployees()
                .stream()
                .map(employee -> this.modelMapper.map(employee,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(String id) {
        EmployeeEntity employee = this.employeeRepository.findEmployeeEntityById(id);
        EmployeeDTO employeeDTO = this.modelMapper.map(employee,EmployeeDTO.class);
        employeeDTO.setCompanyName(employee.getCompany().getName());
        return employeeDTO;
    }

    @Override
    public void deleteById(String id) {
        this.employeeRepository.deleteById(id);
    }
}
