package com.SENA.FlightManagementSystem.Notifications.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "MessageTemplateDto", description = "DTO que representa una plantilla de mensaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageTemplateResDto {
    @Schema(description = "ID único de la plantilla de mensaje", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código de la plantilla de mensaje", example = "WELCOME-001")
    private String code;

    @Schema(description = "Nombre de la plantilla de mensaje", example = "Plantilla de bienvenida")
    private String name;

    @Schema(description = "Plantilla del asunto", example = "Bienvenido a nuestro sistema")
    private String subjectTemplate;

    @Schema(description = "Plantilla del cuerpo del mensaje", example = "Hola {{nombre}}, bienvenido...")
    private String bodyTemplate;
}