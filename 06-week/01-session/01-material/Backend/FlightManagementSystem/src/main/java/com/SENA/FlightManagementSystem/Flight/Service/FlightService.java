package com.SENA.FlightManagementSystem.Flight.Service;

import com.SENA.FlightManagementSystem.Flight.Entity.Flight;
import com.SENA.FlightManagementSystem.Flight.IRepository.IFlightRepository;
import com.SENA.FlightManagementSystem.Flight.IService.IFlightService;
import com.SENA.FlightManagementSystem.Flight.DTO.FlightReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.FlightResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {

    @Autowired
    private IFlightRepository repository;

    @Override
    public List<Flight> all() throws Exception {
        return repository.findAll();
    }

    @Override
    public List<Flight> findByStateTrue() throws Exception {
        return repository.findAll().stream()
                .filter(flight -> flight.getStatus() != null && flight.getStatus())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Flight> findById(String id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public Flight save(Flight flight) throws Exception {
        return repository.save(flight);
    }

    @Override
    public void update(String id, Flight flight) throws Exception {
        Optional<Flight> existing = repository.findById(id);
        if (existing.isPresent()) {
            flight.setId(id);
            repository.save(flight);
        } else {
            throw new Exception("Flight not found");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public FlightResDto mapToResDto(Flight entity) {
        return FlightResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Flight mapToEntity(FlightReqDto dto) {
        Flight flight = new Flight();
        flight.setCode(dto.getCode());
        flight.setName(dto.getName());
        flight.setDescription(dto.getDescription());
        flight.setStatus(dto.getStatus());
        return flight;
    }
}