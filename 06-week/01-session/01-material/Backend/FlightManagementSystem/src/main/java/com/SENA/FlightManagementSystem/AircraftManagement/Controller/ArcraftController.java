package com.SENA.FlightManagementSystem.AircraftManagement.Controller;

import com.SENA.FlightManagementSystem.AircraftManagement.IService.IArcraftService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/aircraft")
public class ArcraftController extends AAircraftManagementBaseController {

    public ArcraftController(IArcraftService service) {
        super(service, "Aircraft");
    }
}