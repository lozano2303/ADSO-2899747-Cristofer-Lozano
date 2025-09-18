package com.SENA.FlightManagementSystem.HumanResources.Service;

import com.SENA.FlightManagementSystem.HumanResources.IRepository.IHumanResourcesBaseRepository;
import com.SENA.FlightManagementSystem.HumanResources.IRepository.IHumanResourcesEmployeeRepository;
import com.SENA.FlightManagementSystem.HumanResources.Entity.Employee;
import com.SENA.FlightManagementSystem.HumanResources.IService.IHumanResourcesEmployeeService;
import com.SENA.FlightManagementSystem.HumanResources.DTO.EmployeeReqDto;
import com.SENA.FlightManagementSystem.HumanResources.DTO.EmployeeResDto;
import com.SENA.FlightManagementSystem.Security.Entity.Role;
import com.SENA.FlightManagementSystem.Security.Entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceHumanResources extends AHumanResourcesBaseService<Employee, EmployeeReqDto, EmployeeResDto> implements IHumanResourcesEmployeeService {

    @Override
    protected IHumanResourcesBaseRepository<Employee, String> getRepository() {
        return repository;
    }

    @Autowired
    private IHumanResourcesEmployeeRepository repository;

    @Override
    public EmployeeResDto mapToResDto(Employee entity) {
        return EmployeeResDto.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .salary(entity.getSalary())
                .hireDate(entity.getHireDate())
                .roleId(entity.getRole() != null ? entity.getRole().getId() : null)
                .personId(entity.getPerson() != null ? entity.getPerson().getId() : null)
                .build();
    }

    @Override
    public Employee mapToEntity(EmployeeReqDto dto) {
        Employee employee = new Employee();
        employee.setStatus(dto.getStatus());
        employee.setSalary(dto.getSalary());
        employee.setHireDate(dto.getHireDate());

        // For now, we'll create stub entities since related entities are in Security module
        // In a complete implementation, you would inject services from Security module
        if (dto.getRoleId() != null) {
            Role role = new Role();
            role.setId(dto.getRoleId());
            employee.setRole(role);
        }

        if (dto.getPersonId() != null) {
            Person person = new Person();
            person.setId(dto.getPersonId());
            employee.setPerson(person);
        }

        return employee;
    }
}