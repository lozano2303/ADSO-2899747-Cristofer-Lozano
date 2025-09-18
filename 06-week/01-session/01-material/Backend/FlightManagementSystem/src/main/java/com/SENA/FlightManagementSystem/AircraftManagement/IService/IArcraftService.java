package com.SENA.FlightManagementSystem.AircraftManagement.IService;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftReqDto;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftResDto;

import java.util.List;
import java.util.Optional;

public interface IArcraftService extends IAircraftManagementBaseService {
    List<Arcraft> findAll();
    List<Arcraft> findByStatusTrue();
    Optional<Arcraft> findById(String id);
    Arcraft save(Arcraft arcraft);
    void delete(String id);
    ArcraftResDto mapToResDto(Arcraft entity);
    Arcraft mapToEntity(ArcraftReqDto dto);
}