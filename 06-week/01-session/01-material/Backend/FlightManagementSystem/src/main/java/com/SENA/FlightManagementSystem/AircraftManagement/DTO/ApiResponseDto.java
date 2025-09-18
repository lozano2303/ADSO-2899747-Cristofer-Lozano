package com.SENA.FlightManagementSystem.AircraftManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {
    private String message;
    private T data;
    private Boolean success;
}