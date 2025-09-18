package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "RoleDto", description = "DTO que representa un rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleReqDto {
    @Schema(description = "Nombre del rol", example = "Administrador")
    private String name;

    @Schema(description = "Descripción del rol", example = "Acceso administrativo completo")
    private String description;
}