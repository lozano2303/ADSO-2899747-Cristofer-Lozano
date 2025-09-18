package com.SENA.FlightManagementSystem.Infrastructure.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "AirportDto", description = "DTO que representa un aeropuerto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportResDto {
    @Schema(description = "ID único del aeropuerto", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código del aeropuerto", example = "BOG")
    private String code;

    @Schema(description = "Nombre del aeropuerto", example = "Aeropuerto Internacional El Dorado")
    private String name;

    @Schema(description = "Dirección física del aeropuerto", example = "Av. El Dorado #103-9, Bogotá")
    private String address;

    @Schema(description = "ID de la ciudad a la que pertenece el aeropuerto", example = "123e4567-e89b-12d3-a456-426614174000")
    private String cityId;

    @Schema(description = "Nombre de la ciudad", example = "Bogotá")
    private String cityName;
}