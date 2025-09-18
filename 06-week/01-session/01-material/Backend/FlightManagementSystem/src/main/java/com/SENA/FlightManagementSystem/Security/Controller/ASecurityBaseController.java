package com.SENA.FlightManagementSystem.Security.Controller;

import com.SENA.FlightManagementSystem.Security.DTO.ApiResponseDto;
import com.SENA.FlightManagementSystem.Security.Entity.ASecurityBaseEntity;
import com.SENA.FlightManagementSystem.Security.IService.ISecurityBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Abstract base controller providing common CRUD endpoints for Security entities.
 *
 * @param <T> The type of entity extending ASecurityBaseEntity.
 * @param <S> The type of service implementing ISecurityBaseService for the entity.
 */
public abstract class ASecurityBaseController<T extends ASecurityBaseEntity, DReq, DRes, S extends ISecurityBaseService<T, DReq, DRes>> {

    protected S service;
    protected String entityName;

    protected ASecurityBaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<DRes>, List<DRes>>> findByStateTrue() {
        try {
            List<T> entities = service.findByStateTrue();
            List<DRes> dtos = entities.stream().map(service::mapToResDto).toList();
            return ResponseEntity.ok(new ApiResponseDto<List<DRes>, List<DRes>>("Datos obtenidos", dtos, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<DRes>, List<DRes>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes, DRes>> show(@PathVariable String id) {
        try {
            Optional<T> entity = service.findById(id);
            if (entity.isPresent()) {
                DRes responseDto = service.mapToResDto(entity.get());
                return ResponseEntity.ok(new ApiResponseDto<DRes, DRes>("Registro encontrado", responseDto, true));
            } else {
                return ResponseEntity.ok(new ApiResponseDto<DRes, DRes>("Registro no encontrado", null, false));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes, DRes>(e.getMessage(), null, false));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<DRes, DRes>> save(@RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            T saved = service.save(entity);
            DRes responseDto = service.mapToResDto(saved);
            return ResponseEntity.ok(new ApiResponseDto<DRes, DRes>("Datos guardados", responseDto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes, DRes>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDto<Object, Object>> update(@PathVariable String id, @RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            service.update(id, entity);
            return ResponseEntity.ok(new ApiResponseDto<Object, Object>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Object, Object>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDto<Object, Object>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<Object, Object>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Object, Object>(e.getMessage(), null, false));
        }
    }
}
