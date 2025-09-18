package com.SENA.FlightManagementSystem.Flight.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "BaggageDto", description = "DTO que representa un equipaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaggageReqDto {
    @Schema(description = "Código del equipaje", example = "BG001")
    private String code;

    @Schema(description = "Nombre del equipaje", example = "Equipaje de mano")
    private String name;

    @Schema(description = "Descripción del equipaje", example = "Equipaje personal del pasajero")
    private String description;

    @Schema(description = "Estado del equipaje (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "Peso del equipaje en kg", example = "15")
    private Integer weight;

    @Schema(description = "ID del ticket al que pertenece", example = "123e4567-e89b-12d3-a456-426614174000")
    private String ticketId;
}