package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "RoleFormDto", description = "DTO que representa la relación entre roles y formularios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleFormResDto {
    @Schema(description = "ID único de la relación", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Rol relacionado")
    private RoleResDto role;

    @Schema(description = "Formulario relacionado")
    private FormResDto form;
}