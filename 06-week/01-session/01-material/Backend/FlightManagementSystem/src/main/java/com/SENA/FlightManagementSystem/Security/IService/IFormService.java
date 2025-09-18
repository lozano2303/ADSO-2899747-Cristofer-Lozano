package com.SENA.FlightManagementSystem.Security.IService;

import com.SENA.FlightManagementSystem.Security.Entity.Form;
import com.SENA.FlightManagementSystem.Security.DTO.FormReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.FormResDto;

public interface IFormService extends ISecurityBaseService<Form, FormReqDto, FormResDto> {
}
