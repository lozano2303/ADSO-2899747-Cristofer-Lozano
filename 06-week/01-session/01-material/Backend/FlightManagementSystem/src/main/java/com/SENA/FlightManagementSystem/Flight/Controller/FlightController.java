package com.SENA.FlightManagementSystem.Flight.Controller;

import com.SENA.FlightManagementSystem.Flight.Entity.Flight;
import com.SENA.FlightManagementSystem.Flight.IService.IFlightService;
import com.SENA.FlightManagementSystem.Flight.DTO.FlightReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.FlightResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/flight")
public class FlightController extends AFlightBaseController<Flight, FlightReqDto, FlightResDto, IFlightService> {

    public FlightController(IFlightService service) {
        super(service, "Flight");
    }
}
