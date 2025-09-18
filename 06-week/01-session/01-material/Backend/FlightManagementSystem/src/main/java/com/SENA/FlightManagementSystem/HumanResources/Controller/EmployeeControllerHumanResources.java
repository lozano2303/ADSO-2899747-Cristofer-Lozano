package com.SENA.FlightManagementSystem.HumanResources.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.SENA.FlightManagementSystem.HumanResources.Entity.Employee;
import com.SENA.FlightManagementSystem.HumanResources.IService.IHumanResourcesEmployeeService;
import com.SENA.FlightManagementSystem.HumanResources.DTO.EmployeeReqDto;
import com.SENA.FlightManagementSystem.HumanResources.DTO.EmployeeResDto;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/employee")
public class EmployeeControllerHumanResources extends AHumanResourcesBaseController<Employee, EmployeeReqDto, EmployeeResDto, IHumanResourcesEmployeeService> {

    public EmployeeControllerHumanResources(IHumanResourcesEmployeeService service) {
        super(service, "Employee");
    }

}