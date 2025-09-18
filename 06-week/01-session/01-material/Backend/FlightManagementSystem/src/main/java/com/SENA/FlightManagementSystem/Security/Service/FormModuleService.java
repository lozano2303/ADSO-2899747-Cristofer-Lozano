package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.FormModule;
import com.SENA.FlightManagementSystem.Security.Entity.Form;
import com.SENA.FlightManagementSystem.Security.Entity.Module;
import com.SENA.FlightManagementSystem.Security.DTO.FormModuleReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.FormModuleResDto;
import com.SENA.FlightManagementSystem.Security.DTO.FormResDto;
import com.SENA.FlightManagementSystem.Security.DTO.ModuleResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IFormModuleRepository;
import com.SENA.FlightManagementSystem.Security.IService.IFormModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormModuleService extends ASecurityBaseService<FormModule, FormModuleReqDto, FormModuleResDto> implements IFormModuleService {

    @Autowired
    private IFormModuleRepository repository;

    @Override
    protected IFormModuleRepository getRepository() {
        return repository;
    }

    @Override
    public FormModuleResDto mapToResDto(FormModule entity) {
        FormModuleResDto dto = new FormModuleResDto();
        dto.setId(entity.getId());

        if (entity.getFormId() != null) {
            FormResDto formDto = new FormResDto();
            formDto.setId(entity.getFormId().getId());
            formDto.setName(entity.getFormId().getName());
            formDto.setPath(entity.getFormId().getPath());
            dto.setForm(formDto);
        }

        if (entity.getModuleId() != null) {
            ModuleResDto moduleDto = new ModuleResDto();
            moduleDto.setId(entity.getModuleId().getId());
            moduleDto.setName(entity.getModuleId().getName());
            moduleDto.setPath(entity.getModuleId().getPath());
            dto.setModule(moduleDto);
        }

        return dto;
    }

    @Override
    public FormModule mapToEntity(FormModuleReqDto dto) {
        FormModule entity = new FormModule();

        // Note: Form and Module would need to be fetched from repositories
        // This is a simplified version - in real implementation you'd inject repositories
        // entity.setFormId(formRepository.findById(dto.getFormId()).orElse(null));
        // entity.setModuleId(moduleRepository.findById(dto.getModuleId()).orElse(null));

        return entity;
    }
}
