package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.Module;
import com.SENA.FlightManagementSystem.Security.DTO.ModuleReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.ModuleResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IModuleRepository;
import com.SENA.FlightManagementSystem.Security.IService.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService extends ASecurityBaseService<Module, ModuleReqDto, ModuleResDto> implements IModuleService {

    @Autowired
    private IModuleRepository repository;

    @Override
    protected IModuleRepository getRepository() {
        return repository;
    }

    @Override
    public ModuleResDto mapToResDto(Module entity) {
        ModuleResDto dto = new ModuleResDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setColor(entity.getColor());
        dto.setIcon(entity.getIcon());
        dto.setPath(entity.getPath());
        return dto;
    }

    @Override
    public Module mapToEntity(ModuleReqDto dto) {
        Module entity = new Module();
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        entity.setIcon(dto.getIcon());
        entity.setPath(dto.getPath());
        return entity;
    }
}
