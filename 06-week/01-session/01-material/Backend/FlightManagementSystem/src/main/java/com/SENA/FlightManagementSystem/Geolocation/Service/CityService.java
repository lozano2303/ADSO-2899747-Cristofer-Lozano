package com.SENA.FlightManagementSystem.Geolocation.Service;

import com.SENA.FlightManagementSystem.Geolocation.Entity.City;
import com.SENA.FlightManagementSystem.Geolocation.Entity.State;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IBaseRepositoryGeolocation;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.ICityRepository;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICityService;
import com.SENA.FlightManagementSystem.Geolocation.IService.IStateService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CityReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CityResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends ABaseServiceGeolocation<City, CityReqDto, CityResDto> implements ICityService {
    @Override
    protected IBaseRepositoryGeolocation<City, String> getRepository() {
        return repository;
    }

    @Autowired
    private ICityRepository repository;

    @Autowired
    private IStateService stateService;

    @Override
    public CityResDto mapToResDto(City entity) {
        return CityResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .stateId(entity.getState() != null ? entity.getState().getId() : null)
                .stateName(entity.getState() != null ? entity.getState().getName() : null)
                .build();
    }

    @Override
    public City mapToEntity(CityReqDto dto) {
        City city = new City();
        city.setCode(dto.getCode());
        city.setName(dto.getName());
        city.setDescription(dto.getDescription());
        city.setStatus(dto.getStatus());

        if (dto.getStateId() != null) {
            try {
                State state = stateService.findById(dto.getStateId()).orElse(null);
                city.setState(state);
            } catch (Exception e) {
                // Log error or handle appropriately
                city.setState(null);
            }
        }

        return city;
    }
}
