package com.SENA.FlightManagementSystem.Security.IService;

import com.SENA.FlightManagementSystem.Security.Entity.Module;
import com.SENA.FlightManagementSystem.Security.DTO.ModuleReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.ModuleResDto;

public interface IModuleService extends ISecurityBaseService<Module, ModuleReqDto, ModuleResDto> {
}
