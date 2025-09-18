package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "UserAccountDto", description = "DTO que representa una cuenta de usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountResDto {
    @Schema(description = "ID único de la cuenta de usuario", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Nombre de usuario", example = "j.perez")
    private String username;

    @Schema(description = "Persona asociada")
    private PersonResDto person;

    @Schema(description = "Rol asignado")
    private RoleResDto role;
}