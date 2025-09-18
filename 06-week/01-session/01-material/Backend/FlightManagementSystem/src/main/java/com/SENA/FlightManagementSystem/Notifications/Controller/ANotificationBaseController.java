package com.SENA.FlightManagementSystem.Notifications.Controller;

import com.SENA.FlightManagementSystem.Infrastructure.DTO.ApiResponseDto;
import com.SENA.FlightManagementSystem.Notifications.Entity.ANotificationBaseEntity;
import com.SENA.FlightManagementSystem.Notifications.IService.INotificationBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class ANotificationBaseController<T extends ANotificationBaseEntity, DReq, DRes, S extends INotificationBaseService<T, DReq, DRes>> {

    protected S service;
    protected String entityName;

    protected ANotificationBaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<DRes>>> findByStateTrue() {
        try {
            List<T> entities = service.findByStateTrue();
            List<DRes> dtos = entities.stream().map(service::mapToResDto).toList();
            return ResponseEntity.ok(new ApiResponseDto<>("Datos obtenidos", dtos, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> show(@PathVariable String id) {
        try {
            Optional<T> entity = service.findById(id);
            if (entity.isPresent()) {
                DRes responseDto = service.mapToResDto(entity.get());
                return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", responseDto, true));
            } else {
                return ResponseEntity.ok(new ApiResponseDto<>("Registro no encontrado", null, false));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<DRes>> save(@RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            T saved = service.save(entity);
            DRes responseDto = service.mapToResDto(saved);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos guardados", responseDto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> update(@PathVariable String id, @RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            service.update(id, entity);
            return ResponseEntity.ok(new ApiResponseDto<>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
