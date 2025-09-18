package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "RoleDto", description = "DTO que representa un rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResDto {
    @Schema(description = "ID único del rol", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Nombre del rol", example = "Administrador")
    private String name;

    @Schema(description = "Descripción del rol", example = "Acceso administrativo completo")
    private String description;
}