package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.Entity.City;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICityService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CityReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CityResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/city")
public class CityController extends ABaseControllerGeolocation<City, CityReqDto, CityResDto, ICityService> {

    public CityController(ICityService service) {
        super(service, "City");
    }

}