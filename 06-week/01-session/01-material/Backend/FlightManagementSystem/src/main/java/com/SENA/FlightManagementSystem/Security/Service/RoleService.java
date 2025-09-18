package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.Role;
import com.SENA.FlightManagementSystem.Security.DTO.RoleReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.RoleResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IRoleRepository;
import com.SENA.FlightManagementSystem.Security.IService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ASecurityBaseService<Role, RoleReqDto, RoleResDto> implements IRoleService {

    @Autowired
    private IRoleRepository repository;

    @Override
    protected IRoleRepository getRepository() {
        return repository;
    }

    @Override
    public RoleResDto mapToResDto(Role entity) {
        RoleResDto dto = new RoleResDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public Role mapToEntity(RoleReqDto dto) {
        Role entity = new Role();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
