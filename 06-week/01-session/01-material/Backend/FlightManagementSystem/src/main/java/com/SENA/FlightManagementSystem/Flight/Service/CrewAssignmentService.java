package com.SENA.FlightManagementSystem.Flight.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENA.FlightManagementSystem.Flight.Entity.CrewAssignment;
import com.SENA.FlightManagementSystem.Flight.IRepository.ICrewAssignmentRepository;
import com.SENA.FlightManagementSystem.Flight.IService.ICrewAssignmentService;
import com.SENA.FlightManagementSystem.Flight.DTO.CrewAssignmentReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.CrewAssignmentResDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrewAssignmentService implements ICrewAssignmentService {

    @Autowired
    private ICrewAssignmentRepository repository;

    @Override
    public List<CrewAssignment> all() throws Exception {
        return repository.findAll();
    }

    @Override
    public List<CrewAssignment> findByStateTrue() throws Exception {
        return repository.findAll().stream()
                .filter(crewAssignment -> crewAssignment.getStatus() != null && crewAssignment.getStatus())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CrewAssignment> findById(String id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public CrewAssignment save(CrewAssignment crewAssignment) throws Exception {
        return repository.save(crewAssignment);
    }

    @Override
    public void update(String id, CrewAssignment crewAssignment) throws Exception {
        Optional<CrewAssignment> existing = repository.findById(id);
        if (existing.isPresent()) {
            crewAssignment.setId(id);
            repository.save(crewAssignment);
        } else {
            throw new Exception("CrewAssignment not found");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public CrewAssignmentResDto mapToResDto(CrewAssignment entity) {
        return CrewAssignmentResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .flightId(entity.getFlightId())
                .employeeId(entity.getEmployeeId())
                .crewRoleId(entity.getCrewRoleId())
                .build();
    }

    @Override
    public CrewAssignment mapToEntity(CrewAssignmentReqDto dto) {
        CrewAssignment crewAssignment = new CrewAssignment();
        crewAssignment.setCode(dto.getCode());
        crewAssignment.setName(dto.getName());
        crewAssignment.setDescription(dto.getDescription());
        crewAssignment.setStatus(dto.getStatus());
        crewAssignment.setFlightId(dto.getFlightId());
        crewAssignment.setEmployeeId(dto.getEmployeeId());
        crewAssignment.setCrewRoleId(dto.getCrewRoleId());

        return crewAssignment;
    }
}