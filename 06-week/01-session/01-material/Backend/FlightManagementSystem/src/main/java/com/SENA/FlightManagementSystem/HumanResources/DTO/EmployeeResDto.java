package com.SENA.FlightManagementSystem.HumanResources.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(name = "EmployeeDto", description = "DTO que representa un empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResDto {
    @Schema(description = "ID único del empleado", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Estado del empleado (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "Salario del empleado", example = "3500.50")
    private Double salary;

    @Schema(description = "Fecha de contratación del empleado", example = "2023-01-15T08:00:00")
    private LocalDateTime hireDate;

    @Schema(description = "ID del rol del empleado", example = "123e4567-e89b-12d3-a456-426614174000")
    private String roleId;

    @Schema(description = "Nombre del rol del empleado", example = "Piloto")
    private String roleName;

    @Schema(description = "ID de la persona asociada al empleado", example = "123e4567-e89b-12d3-a456-426614174001")
    private String personId;

    @Schema(description = "Nombre de la persona", example = "Juan Pérez")
    private String personName;
}