package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.RoleForm;
import com.SENA.FlightManagementSystem.Security.Entity.Role;
import com.SENA.FlightManagementSystem.Security.Entity.Form;
import com.SENA.FlightManagementSystem.Security.DTO.RoleFormReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.RoleFormResDto;
import com.SENA.FlightManagementSystem.Security.DTO.RoleResDto;
import com.SENA.FlightManagementSystem.Security.DTO.FormResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IRoleFormRepository;
import com.SENA.FlightManagementSystem.Security.IService.IRoleFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleFormService extends ASecurityBaseService<RoleForm, RoleFormReqDto, RoleFormResDto> implements IRoleFormService {

    @Autowired
    private IRoleFormRepository repository;

    @Override
    protected IRoleFormRepository getRepository() {
        return repository;
    }

    @Override
    public RoleFormResDto mapToResDto(RoleForm entity) {
        RoleFormResDto dto = new RoleFormResDto();
        dto.setId(entity.getId());

        if (entity.getRoleId() != null) {
            RoleResDto roleDto = new RoleResDto();
            roleDto.setId(entity.getRoleId().getId());
            roleDto.setName(entity.getRoleId().getName());
            roleDto.setDescription(entity.getRoleId().getDescription());
            dto.setRole(roleDto);
        }

        if (entity.getFormId() != null) {
            FormResDto formDto = new FormResDto();
            formDto.setId(entity.getFormId().getId());
            formDto.setName(entity.getFormId().getName());
            formDto.setPath(entity.getFormId().getPath());
            dto.setForm(formDto);
        }

        return dto;
    }

    @Override
    public RoleForm mapToEntity(RoleFormReqDto dto) {
        RoleForm entity = new RoleForm();

        // Note: Role and Form would need to be fetched from repositories
        // This is a simplified version - in real implementation you'd inject repositories
        // entity.setRoleId(roleRepository.findById(dto.getRoleId()).orElse(null));
        // entity.setFormId(formRepository.findById(dto.getFormId()).orElse(null));

        return entity;
    }
}
