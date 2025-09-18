package com.SENA.FlightManagementSystem.Flight.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket", schema = "flight")
public class Ticket extends AFlightBaseEntity{

    @Column(name = "ticket_code", unique = true, nullable = false, length = 50)
    private String ticketCode;

    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @Column(name = "ticket_class_id", nullable = false)
    private Long ticketClassId;

    @Column(name = "seat_number", length = 10)
    private String seatNumber;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // El campo status se hereda de AFlightBaseEntity como Boolean
    // No necesitamos definirlo aquí

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getTicketClassId() {
        return ticketClassId;
    }

    public void setTicketClassId(Long ticketClassId) {
        this.ticketClassId = ticketClassId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Los métodos getStatus() y setStatus() se heredan de AFlightBaseEntity

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
