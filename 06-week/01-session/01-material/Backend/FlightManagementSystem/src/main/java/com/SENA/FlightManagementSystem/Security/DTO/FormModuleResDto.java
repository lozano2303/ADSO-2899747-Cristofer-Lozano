package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "FormModuleDto", description = "DTO que representa la relación entre formularios y módulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormModuleResDto {
    @Schema(description = "ID único de la relación", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Formulario relacionado")
    private FormResDto form;

    @Schema(description = "Módulo relacionado")
    private ModuleResDto module;
}