package com.SENA.FlightManagementSystem.Infrastructure.Service;

import com.SENA.FlightManagementSystem.Infrastructure.Entity.Airport;
import com.SENA.FlightManagementSystem.Geolocation.Entity.City;
import com.SENA.FlightManagementSystem.Infrastructure.IRepository.IAirportRepository;
import com.SENA.FlightManagementSystem.Infrastructure.IService.IAirportService;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.AirportReqDto;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.AirportResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends AInfrastructureBaseService<Airport, AirportReqDto, AirportResDto> implements IAirportService {

    @Override
    protected IAirportRepository getRepository() {
        return repository;
    }

    @Autowired
    private IAirportRepository repository;

    @Override
    public AirportResDto mapToResDto(Airport entity) {
        return AirportResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .address(entity.getAddress())
                .cityId(entity.getCityId() != null ? entity.getCityId().getId() : null)
                .cityName(entity.getCityId() != null ? entity.getCityId().getName() : null)
                .build();
    }

    @Override
    public Airport mapToEntity(AirportReqDto dto) {
        Airport airport = new Airport();
        airport.setCode(dto.getCode());
        airport.setName(dto.getName());
        airport.setAddress(dto.getAddress());

        if (dto.getCityId() != null) {
            City city = new City();
            city.setId(dto.getCityId());
            airport.setCityId(city);
        }

        return airport;
    }
}
