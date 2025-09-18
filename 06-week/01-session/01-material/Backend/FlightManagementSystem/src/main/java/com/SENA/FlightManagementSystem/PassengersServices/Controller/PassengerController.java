package com.SENA.FlightManagementSystem.PassengersServices.Controller;

import com.SENA.FlightManagementSystem.PassengersServices.Entity.Passenger;
import com.SENA.FlightManagementSystem.PassengersServices.IService.IPassengersServicesPassengerService;
import com.SENA.FlightManagementSystem.PassengersServices.DTO.PassengerReqDto;
import com.SENA.FlightManagementSystem.PassengersServices.DTO.PassengerResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/passengers")
public class PassengerController extends APassengersServicesController<Passenger, PassengerReqDto, PassengerResDto, IPassengersServicesPassengerService> {

    public PassengerController(IPassengersServicesPassengerService service) {
        super(service, "Passenger");
    }
}
