package com.SENA.FlightManagementSystem.PassengersServices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "PassengerDto", description = "DTO que representa un pasajero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerResDto {
    @Schema(description = "ID único del pasajero", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Número de pasajero frecuente", example = "FF123456789")
    private String frequentFlyerNumber;

    @Schema(description = "ID de la persona asociada", example = "123e4567-e89b-12d3-a456-426614174000")
    private String personId;

    @Schema(description = "Nombre completo de la persona", example = "Juan Pérez")
    private String personName;

    @Schema(description = "Estado del pasajero (activo/inactivo)", example = "true")
    private Boolean status;
}