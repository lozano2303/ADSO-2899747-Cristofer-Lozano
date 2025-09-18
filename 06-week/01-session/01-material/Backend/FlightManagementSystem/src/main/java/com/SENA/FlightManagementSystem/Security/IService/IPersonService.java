package com.SENA.FlightManagementSystem.Security.IService;

import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Security.DTO.PersonReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.PersonResDto;

public interface IPersonService extends ISecurityBaseService<Person, PersonReqDto, PersonResDto> {
}
