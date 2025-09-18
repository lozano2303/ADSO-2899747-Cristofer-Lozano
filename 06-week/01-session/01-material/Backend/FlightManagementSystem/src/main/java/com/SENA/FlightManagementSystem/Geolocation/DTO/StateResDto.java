package com.SENA.FlightManagementSystem.Geolocation.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "StateDto", description = "DTO que representa un estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateResDto {
    @Schema(description = "ID único del estado", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código del estado", example = "CA")
    private String code;

    @Schema(description = "Nombre del estado", example = "California")
    private String name;

    @Schema(description = "Descripción del estado", example = "Estado en la costa oeste de EE.UU.")
    private String description;

    @Schema(description = "Estado del estado (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "ID del país al que pertenece", example = "123e4567-e89b-12d3-a456-426614174000")
    private String countryId;

    @Schema(description = "Nombre del país", example = "Estados Unidos")
    private String countryName;
}