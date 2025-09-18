package com.SENA.FlightManagementSystem.Infrastructure.Controller;

import com.SENA.FlightManagementSystem.Infrastructure.Entity.Airport;
import com.SENA.FlightManagementSystem.Infrastructure.IService.IAirportService;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.AirportReqDto;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.AirportResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/airport")
public class AirportController extends AInfrastructureBaseController<Airport, AirportReqDto, AirportResDto, IAirportService> {

    public AirportController(IAirportService service) {
        super(service, "Airport");
    }
}
