package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "ModuleDto", description = "DTO que representa un módulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleReqDto {
    @Schema(description = "Nombre del módulo", example = "Administración")
    private String name;

    @Schema(description = "Color del módulo", example = "#4CAF50")
    private String color;

    @Schema(description = "Ícono del módulo", example = "mdi-view-dashboard")
    private String icon;

    @Schema(description = "Ruta del módulo", example = "/dashboard")
    private String path;
}