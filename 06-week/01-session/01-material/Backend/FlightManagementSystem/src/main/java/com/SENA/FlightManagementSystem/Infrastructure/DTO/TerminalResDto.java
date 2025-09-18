package com.SENA.FlightManagementSystem.Infrastructure.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "TerminalDto", description = "DTO que representa un terminal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerminalResDto {
    @Schema(description = "ID único del terminal", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código del terminal", example = "T1")
    private String code;

    @Schema(description = "Nombre del terminal", example = "Terminal 1")
    private String name;

    @Schema(description = "ID del aeropuerto al que pertenece el terminal", example = "123e4567-e89b-12d3-a456-426614174000")
    private String airportId;

    @Schema(description = "Nombre del aeropuerto", example = "Aeropuerto Internacional El Dorado")
    private String airportName;
}