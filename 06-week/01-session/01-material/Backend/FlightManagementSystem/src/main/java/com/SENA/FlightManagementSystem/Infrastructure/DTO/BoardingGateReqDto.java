package com.SENA.FlightManagementSystem.Infrastructure.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "BoardingGateDto", description = "DTO que representa una puerta de embarque")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardingGateReqDto {
    @Schema(description = "Código de la puerta de embarque", example = "A01")
    private String code;

    @Schema(description = "Nombre de la puerta de embarque", example = "Puerta A01")
    private String name;

    @Schema(description = "ID del terminal al que pertenece la puerta de embarque", example = "123e4567-e89b-12d3-a456-426614174000")
    private String terminalId;
}