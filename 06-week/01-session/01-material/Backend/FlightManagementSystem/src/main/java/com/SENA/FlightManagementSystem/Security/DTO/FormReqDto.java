package com.SENA.FlightManagementSystem.Security.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "FormDto", description = "DTO que representa un formulario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormReqDto {
    @Schema(description = "Nombre del formulario", example = "Usuarios")
    private String name;

    @Schema(description = "Color del formulario", example = "#2196F3")
    private String color;

    @Schema(description = "Ícono del formulario", example = "mdi-form-select")
    private String icon;

    @Schema(description = "Ruta del formulario", example = "/users/list")
    private String path;

    @Schema(description = "Sección a la que pertenece el formulario", example = "Administración")
    private String section;
}