package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.Form;
import com.SENA.FlightManagementSystem.Security.DTO.FormReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.FormResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IFormRepository;
import com.SENA.FlightManagementSystem.Security.IService.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService extends ASecurityBaseService<Form, FormReqDto, FormResDto> implements IFormService {

    @Autowired
    private IFormRepository repository;

    @Override
    protected IFormRepository getRepository() {
        return repository;
    }

    @Override
    public FormResDto mapToResDto(Form entity) {
        FormResDto dto = new FormResDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setColor(entity.getColor());
        dto.setIcon(entity.getIcon());
        dto.setPath(entity.getPath());
        dto.setSection(entity.getSection());
        return dto;
    }

    @Override
    public Form mapToEntity(FormReqDto dto) {
        Form entity = new Form();
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        entity.setIcon(dto.getIcon());
        entity.setPath(dto.getPath());
        entity.setSection(dto.getSection());
        return entity;
    }
}
