package com.SENA.FlightManagementSystem.AircraftManagement.Controller;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import com.SENA.FlightManagementSystem.AircraftManagement.IService.IArcraftService;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftReqDto;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ArcraftResDto;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.ApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AAircraftManagementBaseController {
    protected IArcraftService service;
    protected String entityName;

    protected AAircraftManagementBaseController(IArcraftService service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<ArcraftResDto>>> findByStatusTrue() {
        try {
            List<Arcraft> entities = service.findByStatusTrue();
            List<ArcraftResDto> dtos = entities.stream().map(service::mapToResDto).collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponseDto<List<ArcraftResDto>>("Datos obtenidos", dtos, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ArcraftResDto>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<ArcraftResDto>> show(@PathVariable String id) {
        try {
            Optional<Arcraft> entity = service.findById(id);
            ArcraftResDto dto = entity.map(service::mapToResDto).orElse(null);
            return ResponseEntity.ok(new ApiResponseDto<ArcraftResDto>("Registro encontrado", dto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<ArcraftResDto>(e.getMessage(), null, false));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<ArcraftResDto>> save(@RequestBody ArcraftReqDto dto) {
        try {
            Arcraft entity = service.mapToEntity(dto);
            Arcraft saved = service.save(entity);
            ArcraftResDto responseDto = service.mapToResDto(saved);
            return ResponseEntity.ok(new ApiResponseDto<ArcraftResDto>("Datos guardados", responseDto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<ArcraftResDto>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDto<ArcraftResDto>> update(@PathVariable String id, @RequestBody ArcraftReqDto dto) {
        try {
            // For simplicity, we'll create a new entity and save it
            Arcraft entity = service.mapToEntity(dto);
            entity.setId(id); // Set the ID for update
            Arcraft saved = service.save(entity);
            return ResponseEntity.ok(new ApiResponseDto<ArcraftResDto>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<ArcraftResDto>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDto<ArcraftResDto>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<ArcraftResDto>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<ArcraftResDto>(e.getMessage(), null, false));
        }
    }
}
