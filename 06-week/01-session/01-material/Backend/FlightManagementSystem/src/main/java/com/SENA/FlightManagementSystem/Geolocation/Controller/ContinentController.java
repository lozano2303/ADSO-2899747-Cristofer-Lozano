package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.ContinentReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.ContinentResDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.IService.IContinentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/continent")
public class ContinentController extends ABaseControllerGeolocation<Continent, ContinentReqDto, ContinentResDto, IContinentService>{

    public ContinentController(IContinentService service) {
        super(service, "Continent");
    }
}
