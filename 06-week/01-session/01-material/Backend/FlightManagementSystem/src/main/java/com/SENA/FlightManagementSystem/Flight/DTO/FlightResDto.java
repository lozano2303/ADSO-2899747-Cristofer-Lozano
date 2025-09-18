package com.SENA.FlightManagementSystem.Flight.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "FlightDto", description = "DTO que representa un vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightResDto {
    @Schema(description = "ID único del vuelo", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código del vuelo", example = "FL001")
    private String code;

    @Schema(description = "Nombre del vuelo", example = "Vuelo Bogotá - Medellín")
    private String name;

    @Schema(description = "Descripción del vuelo", example = "Vuelo comercial doméstico")
    private String description;

    @Schema(description = "Estado del vuelo (activo/inactivo)", example = "true")
    private Boolean status;
}