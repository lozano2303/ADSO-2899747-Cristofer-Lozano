package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.Entity.State;
import com.SENA.FlightManagementSystem.Geolocation.IService.IStateService;
import com.SENA.FlightManagementSystem.Geolocation.DTO.StateReqDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.StateResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/state")
public class StateController extends ABaseControllerGeolocation<State, StateReqDto, StateResDto, IStateService>{
    public StateController(IStateService service) {
        super(service, "State");
    }
}
