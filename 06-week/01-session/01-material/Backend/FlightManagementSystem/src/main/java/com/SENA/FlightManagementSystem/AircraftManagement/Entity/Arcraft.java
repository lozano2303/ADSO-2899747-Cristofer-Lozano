package com.SENA.FlightManagementSystem.AircraftManagement.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="aircraft", schema = "aircraft_management")
@Schema(name = "aircraft_management", description = "Entidad que representa la gestión de aeronaves")
public class Arcraft extends AAircraftManagementBaseEntity {

    @Schema(description = "Código de la aeronave", example = "A320-001")
    @Column(name = "code", nullable = false, length = 10, unique = true)
    private String code;

    @Schema(description = "Nombre de la aeronave", example = "Airbus A320")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Schema(description = "Descripción de la aeronave", example = "Aeronave comercial Airbus A320")
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
