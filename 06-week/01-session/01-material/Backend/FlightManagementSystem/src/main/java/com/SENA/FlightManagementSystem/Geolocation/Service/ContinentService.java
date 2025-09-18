package com.SENA.FlightManagementSystem.Geolocation.Service;

import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.DTO.ContinentReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.ContinentResDto;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IBaseRepositoryGeolocation;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IContinentRepository;
import com.SENA.FlightManagementSystem.Geolocation.IService.IContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService extends ABaseServiceGeolocation<Continent, ContinentReqDto, ContinentResDto> implements IContinentService {
    @Override
    protected IBaseRepositoryGeolocation<Continent, String> getRepository() {
        return repository;
    }

    @Autowired
    private IContinentRepository repository;

    @Override
    public ContinentResDto mapToResDto(Continent entity) {
        ContinentResDto dto = new ContinentResDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public Continent mapToEntity(ContinentReqDto dto) {
        Continent entity = new Continent();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
