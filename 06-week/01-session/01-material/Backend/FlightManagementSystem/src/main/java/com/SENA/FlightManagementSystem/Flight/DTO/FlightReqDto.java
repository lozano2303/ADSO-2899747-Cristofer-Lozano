package com.SENA.FlightManagementSystem.Flight.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "FlightDto", description = "DTO que representa un vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightReqDto {
    @Schema(description = "Código del vuelo", example = "FL001")
    private String code;

    @Schema(description = "Nombre del vuelo", example = "Vuelo Bogotá - Medellín")
    private String name;

    @Schema(description = "Descripción del vuelo", example = "Vuelo comercial doméstico")
    private String description;

    @Schema(description = "Estado del vuelo (activo/inactivo)", example = "true")
    private Boolean status;
}