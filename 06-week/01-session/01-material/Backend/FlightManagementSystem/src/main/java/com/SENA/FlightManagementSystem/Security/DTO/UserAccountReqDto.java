package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "UserAccountDto", description = "DTO que representa una cuenta de usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountReqDto {
    @Schema(description = "Nombre de usuario", example = "j.perez")
    private String username;

    @Schema(description = "Contraseña", example = "password123")
    private String password;

    @Schema(description = "ID de la persona asociada", example = "123e4567-e89b-12d3-a456-426614174000")
    private String personId;

    @Schema(description = "ID del rol asignado", example = "123e4567-e89b-12d3-a456-426614174001")
    private String roleId;
}