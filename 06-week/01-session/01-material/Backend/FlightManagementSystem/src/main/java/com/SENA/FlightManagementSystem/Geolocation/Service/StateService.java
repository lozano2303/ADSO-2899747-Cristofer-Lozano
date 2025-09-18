package com.SENA.FlightManagementSystem.Geolocation.Service;

import com.SENA.FlightManagementSystem.Geolocation.Entity.State;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IBaseRepositoryGeolocation;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IStateRepository;
import com.SENA.FlightManagementSystem.Geolocation.IService.IStateService;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.StateReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.StateResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService extends ABaseServiceGeolocation<State, StateReqDto, StateResDto> implements IStateService {
    @Override
    protected IBaseRepositoryGeolocation<State, String> getRepository() {
        return repository;
    }

    @Autowired
    private IStateRepository repository;

    @Autowired
    private ICountryService countryService;

    @Override
    public StateResDto mapToResDto(State entity) {
        return StateResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .countryId(entity.getCountry() != null ? entity.getCountry().getId() : null)
                .countryName(entity.getCountry() != null ? entity.getCountry().getName() : null)
                .build();
    }

    @Override
    public State mapToEntity(StateReqDto dto) {
        State state = new State();
        state.setCode(dto.getCode());
        state.setName(dto.getName());
        state.setDescription(dto.getDescription());
        state.setStatus(dto.getStatus());

        if (dto.getCountryId() != null) {
            try {
                Country country = countryService.findById(dto.getCountryId()).orElse(null);
                state.setCountry(country);
            } catch (Exception e) {
                // Log error or handle appropriately
                state.setCountry(null);
            }
        }

        return state;
    }
}
