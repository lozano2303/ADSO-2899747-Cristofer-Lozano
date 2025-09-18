package com.SENA.FlightManagementSystem.Geolocation.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "ContinentDto", description = "DTO que representa un continente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentReqDto {
    @Schema(description = "Código del continente", example = "AF")
    private String code;

    @Schema(description = "Nombre del continente", example = "Africa")
    private String name;

    @Schema(description = "Descripción del continente", example = "Continente africano")
    private String description;

    @Schema(description = "Estado del continente (activo/inactivo)", example = "true")
    private Boolean status;
}
