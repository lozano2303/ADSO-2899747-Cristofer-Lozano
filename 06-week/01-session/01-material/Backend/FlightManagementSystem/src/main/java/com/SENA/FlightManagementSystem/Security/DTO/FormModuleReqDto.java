package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "FormModuleDto", description = "DTO que representa la relación entre formularios y módulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormModuleReqDto {
    @Schema(description = "ID del formulario", example = "123e4567-e89b-12d3-a456-426614174000")
    private String formId;

    @Schema(description = "ID del módulo", example = "123e4567-e89b-12d3-a456-426614174001")
    private String moduleId;
}