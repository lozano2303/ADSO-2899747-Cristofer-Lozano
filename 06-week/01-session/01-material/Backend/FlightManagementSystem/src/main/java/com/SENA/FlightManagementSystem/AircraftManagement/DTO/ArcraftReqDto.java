package com.SENA.FlightManagementSystem.AircraftManagement.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "ArcraftDto", description = "DTO que representa una aeronave")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArcraftReqDto {
    @Schema(description = "Código de la aeronave", example = "A320-001")
    private String code;

    @Schema(description = "Nombre de la aeronave", example = "Airbus A320")
    private String name;

    @Schema(description = "Descripción de la aeronave", example = "Aeronave comercial Airbus A320")
    private String description;

    @Schema(description = "Estado de la aeronave (activo/inactivo)", example = "true")
    private Boolean status;
}