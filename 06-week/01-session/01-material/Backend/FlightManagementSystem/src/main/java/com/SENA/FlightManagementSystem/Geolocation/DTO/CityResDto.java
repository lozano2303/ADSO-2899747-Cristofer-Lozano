package com.SENA.FlightManagementSystem.Geolocation.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "CityDto", description = "DTO que representa una ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityResDto {
    @Schema(description = "ID único de la ciudad", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código de la ciudad", example = "NYC")
    private String code;

    @Schema(description = "Nombre de la ciudad", example = "Nueva York")
    private String name;

    @Schema(description = "Descripción de la ciudad", example = "Ciudad principal de Nueva York")
    private String description;

    @Schema(description = "Estado de la ciudad (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "ID del estado al que pertenece", example = "123e4567-e89b-12d3-a456-426614174000")
    private String stateId;

    @Schema(description = "Nombre del estado", example = "Nueva York")
    private String stateName;
}