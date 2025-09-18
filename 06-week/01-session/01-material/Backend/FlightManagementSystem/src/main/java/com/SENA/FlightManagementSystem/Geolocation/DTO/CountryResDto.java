package com.SENA.FlightManagementSystem.Geolocation.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "CountryDto", description = "DTO que representa un país")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResDto {
    @Schema(description = "ID único del país", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código del país", example = "CO")
    private String code;

    @Schema(description = "Nombre del país", example = "Colombia")
    private String name;

    @Schema(description = "Descripción del país", example = "País en América del Sur")
    private String description;

    @Schema(description = "Estado del país (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "ID del continente al que pertenece", example = "123e4567-e89b-12d3-a456-426614174000")
    private String continentId;

    @Schema(description = "Nombre del continente", example = "América")
    private String continentName;
}