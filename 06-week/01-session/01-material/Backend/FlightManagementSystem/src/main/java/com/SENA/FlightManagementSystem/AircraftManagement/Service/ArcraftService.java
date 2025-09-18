package com.SENA.FlightManagementSystem.AircraftManagement.Service;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import com.SENA.FlightManagementSystem.AircraftManagement.IRepository.IArcraftRepository;
import com.SENA.FlightManagementSystem.AircraftManagement.IService.IArcraftService;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftReqDto;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArcraftService implements IArcraftService {

    @Autowired
    private IArcraftRepository repository;

    public List<Arcraft> findAll() {
        return repository.findAll();
    }

    public List<Arcraft> findByStatusTrue() {
        return repository.findAll().stream()
                .filter(arcraft -> arcraft.getStatus() != null && arcraft.getStatus())
                .collect(Collectors.toList());
    }

    public Optional<Arcraft> findById(String id) {
        return repository.findById(id);
    }

    public Arcraft save(Arcraft arcraft) {
        return repository.save(arcraft);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public ArcraftResDto mapToResDto(Arcraft entity) {
        return ArcraftResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }

    public Arcraft mapToEntity(ArcraftReqDto dto) {
        Arcraft arcraft = new Arcraft();
        arcraft.setCode(dto.getCode());
        arcraft.setName(dto.getName());
        arcraft.setDescription(dto.getDescription());
        arcraft.setStatus(dto.getStatus());
        return arcraft;
    }
}