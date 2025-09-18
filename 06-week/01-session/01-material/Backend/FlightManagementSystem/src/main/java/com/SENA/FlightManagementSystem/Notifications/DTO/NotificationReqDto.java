package com.SENA.FlightManagementSystem.Notifications.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(name = "NotificationDto", description = "DTO que representa una notificación")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationReqDto {
    @Schema(description = "ID de la persona destinataria", example = "123e4567-e89b-12d3-a456-426614174000")
    private String personId;

    @Schema(description = "Canal de envío de la notificación", example = "EMAIL")
    private String channel;

    @Schema(description = "Asunto de la notificación", example = "Confirmación de vuelo")
    private String subject;

    @Schema(description = "Mensaje de la notificación", example = "Su vuelo ha sido confirmado exitosamente")
    private String message;

    @Schema(description = "Fecha y hora de envío", example = "2023-12-01T10:00:00")
    private LocalDateTime sentAt;

    @Schema(description = "Estado de la notificación", example = "SENT")
    private String status;
}