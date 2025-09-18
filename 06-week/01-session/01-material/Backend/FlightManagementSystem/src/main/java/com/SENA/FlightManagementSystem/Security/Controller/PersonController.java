package com.SENA.FlightManagementSystem.Security.Controller;

import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Security.IService.IPersonService;
import com.SENA.FlightManagementSystem.Security.DTO.PersonReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.PersonResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/person")
public class PersonController extends ASecurityBaseController<Person, PersonReqDto, PersonResDto, IPersonService> {

    public PersonController(IPersonService service) {
        super(service, "Person");
    }
}
