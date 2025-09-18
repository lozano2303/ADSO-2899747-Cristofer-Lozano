package com.SENA.FlightManagementSystem.Security.IService;

import com.SENA.FlightManagementSystem.Security.Entity.Role;
import com.SENA.FlightManagementSystem.Security.DTO.RoleReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.RoleResDto;

public interface IRoleService extends ISecurityBaseService<Role, RoleReqDto, RoleResDto> {
}
