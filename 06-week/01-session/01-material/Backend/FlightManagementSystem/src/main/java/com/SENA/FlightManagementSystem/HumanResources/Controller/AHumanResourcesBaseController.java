package com.SENA.FlightManagementSystem.HumanResources.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.SENA.FlightManagementSystem.HumanResources.DTO.ApiResponseDto;
import com.SENA.FlightManagementSystem.HumanResources.Entity.AHumanResourcesBaseEntity;
import com.SENA.FlightManagementSystem.HumanResources.IService.IHumanResourcesBaseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * Abstract base controller providing common CRUD endpoints for entities.
 *
 * @param <T> The type of entity extending AHumanResourcesBaseEntity.
 * @param <DReq> The type of request DTO.
 * @param <DRes> The type of response DTO.
 * @param <S> The type of service implementing IHumanResourcesBaseService for the entity.
 */
public abstract class AHumanResourcesBaseController<T extends AHumanResourcesBaseEntity, DReq, DRes, S extends IHumanResourcesBaseService<T, DReq, DRes>> {

    protected S service;
    protected String entityName;

    /**
     * Constructor for ABaseController.
     * 
     * @param service    The service for the entity.
     * @param entityName The name of the entity.
     */
    protected AHumanResourcesBaseController(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    /**
     * Retrieves all entities with state set to true.
     *
     * @return A ResponseEntity containing ApiResponseDto with list of response DTOs if
     *         successful, or error message if unsuccessful.
     */
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

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return A ResponseEntity containing ApiResponseDto with the entity response DTO if found,
     *         or error message if not found.
     */
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<DRes>> show(@PathVariable String id) {
        try {
            Optional<T> entity = service.findById(id);
            if (entity.isPresent()) {
                DRes responseDto = service.mapToResDto(entity.get());
                return ResponseEntity.ok(new ApiResponseDto<DRes>("Registro encontrado", responseDto, true));
            } else {
                return ResponseEntity.ok(new ApiResponseDto<DRes>("Registro no encontrado", null, false));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }

    /**
     * Saves an entity.
     *
     * @param dto The request DTO to save.
     * @return A ResponseEntity containing ApiResponseDto with the saved entity response DTO if
     *         successful, or error message if unsuccessful.
     */
    @PostMapping
    public ResponseEntity<ApiResponseDto<DRes>> save(@RequestBody DReq dto) {
        try {
            T entity = service.mapToEntity(dto);
            T savedEntity = service.save(entity);
            DRes responseDto = service.mapToResDto(savedEntity);
            return ResponseEntity.ok(new ApiResponseDto<DRes>("Datos guardados", responseDto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<DRes>(e.getMessage(), null, false));
        }
    }

    /**
     * Updates an existing entity by its ID.
     *
     * @param id  The ID of the entity to update.
     * @param dto The request DTO with updated data.
     * @return A ResponseEntity containing ApiResponseDto with success message if
     *         successful, or error message if unsuccessful.
     */
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

    /**
     * Deletes an entity by its ID.
     * 
     * @param id The ID of the entity to delete.
     * @return A ResponseEntity containing ApiResponseDto with success message if
     *         successful,
     *         or error message if unsuccessful.
     */
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