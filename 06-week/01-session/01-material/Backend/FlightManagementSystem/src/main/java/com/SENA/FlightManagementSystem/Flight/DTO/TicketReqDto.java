package com.SENA.FlightManagementSystem.Flight.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(name = "TicketDto", description = "DTO que representa un ticket de vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketReqDto {
    @Schema(description = "Código único del ticket", example = "TK001")
    private String ticketCode;

    @Schema(description = "ID del vuelo", example = "123e4567-e89b-12d3-a456-426614174000")
    private Long flightId;

    @Schema(description = "ID del pasajero", example = "123e4567-e89b-12d3-a456-426614174001")
    private Long passengerId;

    @Schema(description = "ID de la clase del ticket", example = "123e4567-e89b-12d3-a456-426614174002")
    private Long ticketClassId;

    @Schema(description = "Número del asiento", example = "12A")
    private String seatNumber;

    @Schema(description = "Precio del ticket", example = "150000.00")
    private BigDecimal price;

    @Schema(description = "Estado del ticket (activo/inactivo)", example = "true")
    private Boolean status;

    @Schema(description = "Fecha de compra", example = "2023-12-01T10:00:00")
    private LocalDateTime purchaseDate;
}