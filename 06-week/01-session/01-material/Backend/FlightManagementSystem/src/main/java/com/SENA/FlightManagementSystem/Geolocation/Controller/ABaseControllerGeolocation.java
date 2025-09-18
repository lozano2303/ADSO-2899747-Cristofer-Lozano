package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.Entity.ABaseEntityGeo;
import com.SENA.FlightManagementSystem.Geolocation.IService.IBaseServiceGeolocation;
import com.SENA.FlightManagementSystem.Geolocation.DTO.ApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ABaseControllerGeolocation <T extends ABaseEntityGeo, DReq, DRes, S extends IBaseServiceGeolocation<T, DReq, DRes>> {
    protected S service;
    protected String entityName;

    protected ABaseControllerGeolocation(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<DRes>>> findByStateTrue() {
        try {
            List<T> entities = service.findByStateTrue();
            List<DRes> dtos = entities.stream().map(service::mapToResDto).collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponseDto<List<DRes>>("Datos obtenidos", dtos, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<DRes>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> show(@PathVariable String id) {
        try {
            Optional<T> entity = service.findById(id);
            DRes dto = entity.map(service::mapToResDto).orElse(null);
            return ResponseEntity.ok(new ApiResponseDto<DRes>("Registro encontrado", dto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<DRes>> save(@RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            T saved = service.save(entity);
            DRes responseDto = service.mapToResDto(saved);
            return ResponseEntity.ok(new ApiResponseDto<DRes>("Datos guardados", responseDto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> update(@PathVariable String id, @RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            service.update(id, entity);
            return ResponseEntity.ok(new ApiResponseDto<DRes>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<DRes>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }
}
