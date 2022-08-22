package bg.softuni.project.linkedout.service.impl;

import bg.softuni.project.linkedout.model.dto.CompanyDTO;
import bg.softuni.project.linkedout.model.entities.CompanyEntity;
import bg.softuni.project.linkedout.model.entities.EmployeeEntity;
import bg.softuni.project.linkedout.repository.CompanyRepository;
import bg.softuni.project.linkedout.repository.EmployeeRepository;
import bg.softuni.project.linkedout.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = this.modelMapper.map(companyDTO, CompanyEntity.class);
        companyEntity.setId(UUID.randomUUID().toString());
        this.companyRepository.save(companyEntity);
    }

    @Override
    public List<CompanyDTO> getAll() {
        return this.companyRepository.findAllCompanies()
                .stream()
                .map(company -> this.modelMapper.map(company,CompanyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(String id) {
        return this.modelMapper.map(this.companyRepository.findCompanyEntityById(id),CompanyDTO.class);
    }

    @Override
    public void deleteById(String id) {

      CompanyEntity companyEntity = this.companyRepository.findCompanyEntityById(id);
      List<EmployeeEntity> employeeEntities =  this.employeeRepository.findEmployeeEntityByCompanyName(companyEntity.getName());
     this.employeeRepository.deleteAll(employeeEntities);
      this.companyRepository.deleteById(id);

    }
}
