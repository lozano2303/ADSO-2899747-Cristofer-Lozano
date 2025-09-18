package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "RoleFormDto", description = "DTO que representa la relación entre roles y formularios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleFormReqDto {
    @Schema(description = "ID del rol", example = "123e4567-e89b-12d3-a456-426614174000")
    private String roleId;

    @Schema(description = "ID del formulario", example = "123e4567-e89b-12d3-a456-426614174001")
    private String formId;
}