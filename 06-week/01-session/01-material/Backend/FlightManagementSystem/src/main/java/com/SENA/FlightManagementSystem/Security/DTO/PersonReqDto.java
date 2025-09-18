package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(name = "PersonDto", description = "DTO que representa una persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonReqDto {
    @Schema(description = "Primer nombre", example = "Juan")
    private String firstName;

    @Schema(description = "Apellido", example = "Pérez")
    private String lastName;

    @Schema(description = "Número de documento", example = "1234567890")
    private String documentNumber;

    @Schema(description = "Fecha de nacimiento", example = "1990-05-20")
    private LocalDate birthDate;

    @Schema(description = "Género", example = "M")
    private String gender;

    @Schema(description = "Teléfono", example = "+57 300 123 4567")
    private String phone;

    @Schema(description = "Correo electrónico", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Dirección", example = "Calle 123 #45-67")
    private String address;

    @Schema(description = "Nombre del acudiente")
    private String attendantName;

    @Schema(description = "Teléfono del acudiente")
    private String attendingPhone;

    @Schema(description = "ID del tipo de documento", example = "123e4567-e89b-12d3-a456-426614174000")
    private String documentTypeId;

    @Schema(description = "ID de la ciudad", example = "123e4567-e89b-12d3-a456-426614174000")
    private String cityId;
}