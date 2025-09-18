package com.SENA.FlightManagementSystem.PassengersServices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "PassengerDto", description = "DTO que representa un pasajero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerReqDto {
    @Schema(description = "Número de pasajero frecuente", example = "FF123456789")
    private String frequentFlyerNumber;

    @Schema(description = "ID de la persona asociada", example = "123e4567-e89b-12d3-a456-426614174000")
    private String personId;

    @Schema(description = "Estado del pasajero (activo/inactivo)", example = "true")
    private Boolean status;
}