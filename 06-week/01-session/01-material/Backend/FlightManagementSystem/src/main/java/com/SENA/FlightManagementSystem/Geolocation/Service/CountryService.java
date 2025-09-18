package com.SENA.FlightManagementSystem.Geolocation.Service;

import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.IBaseRepositoryGeolocation;
import com.SENA.FlightManagementSystem.Geolocation.IRepository.ICountryRepository;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import com.SENA.FlightManagementSystem.Geolocation.IService.IContinentService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CountryReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CountryResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService  extends ABaseServiceGeolocation<Country, CountryReqDto, CountryResDto> implements ICountryService {
    @Override
    protected IBaseRepositoryGeolocation<Country, String> getRepository() {
        return repository;
    }

    @Autowired
    private ICountryRepository repository;

    @Autowired
    private IContinentService continentService;

    @Override
    public CountryResDto mapToResDto(Country entity) {
        return CountryResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .continentId(entity.getContinent() != null ? entity.getContinent().getId() : null)
                .continentName(entity.getContinent() != null ? entity.getContinent().getName() : null)
                .build();
    }

    @Override
    public Country mapToEntity(CountryReqDto dto) {
        Country country = new Country();
        country.setCode(dto.getCode());
        country.setName(dto.getName());
        country.setDescription(dto.getDescription());
        country.setStatus(dto.getStatus());

        if (dto.getContinentId() != null) {
            try {
                Continent continent = continentService.findById(dto.getContinentId()).orElse(null);
                country.setContinent(continent);
            } catch (Exception e) {
                // Log error or handle appropriately
                country.setContinent(null);
            }
        }

        return country;
    }
}
