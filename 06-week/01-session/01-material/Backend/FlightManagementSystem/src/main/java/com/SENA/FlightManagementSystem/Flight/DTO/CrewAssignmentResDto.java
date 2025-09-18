package com.SENA.FlightManagementSystem.Flight.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "CrewAssignmentDto", description = "DTO que representa una asignación de tripulación")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrewAssignmentResDto {
    @Schema(description = "ID único de la asignación", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código de la asignación", example = "CA001")
    private String code;

    @Schema(description = "Nombre de la asignación", example = "Piloto Principal")
    private String name;

    @Schema(description = "Descripción de la asignación", example = "Asignación del piloto al vuelo")
    private String description;

    @Schema(description = "Estado de la asignación (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "ID del vuelo", example = "123e4567-e89b-12d3-a456-426614174000")
    private String flightId;

    @Schema(description = "ID del empleado", example = "123e4567-e89b-12d3-a456-426614174001")
    private String employeeId;

    @Schema(description = "ID del rol de tripulación", example = "123e4567-e89b-12d3-a456-426614174002")
    private String crewRoleId;
}