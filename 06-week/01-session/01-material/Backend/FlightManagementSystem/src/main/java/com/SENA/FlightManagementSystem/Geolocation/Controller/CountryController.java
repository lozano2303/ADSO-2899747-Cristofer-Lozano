package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CountryReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.CountryResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/country")
public class CountryController extends ABaseControllerGeolocation<Country, CountryReqDto, CountryResDto, ICountryService> {
    public CountryController(ICountryService service) {
        super(service, "Country");
    }
}
