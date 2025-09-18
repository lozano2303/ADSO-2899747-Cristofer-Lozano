package com.SENA.FlightManagementSystem.Flight.Controller;

import java.util.List;
import java.util.Optional;

import com.SENA.FlightManagementSystem.Flight.Entity.AFlightBaseEntity;
import com.SENA.FlightManagementSystem.Flight.IService.IFlightBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.SENA.FlightManagementSystem.Flight.DTO.ApiResponseDto;

/**
 * Abstract base controller providing common CRUD endpoints for Flight entities.
 *
 * @param <T> The type of entity extending AFlightBaseEntity.
 * @param <DReq> The type of request DTO.
 * @param <DRes> The type of response DTO.
 * @param <S> The type of service implementing IFlightBaseService for the entity.
 */
public abstract class AFlightBaseController<T extends AFlightBaseEntity, DReq, DRes, S extends IFlightBaseService<T, DReq, DRes>> {

    protected S service;
    protected String entityName;

    protected AFlightBaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<DRes>>> findByStateTrue() {
        try {
            List<T> entities = service.findByStateTrue();
            List<DRes> dtos = entities.stream().map(service::mapToResDto).toList();
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
    public ResponseEntity<ApiResponseDto<T>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<T>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<T>(e.getMessage(), null, false));
        }
    }
}
