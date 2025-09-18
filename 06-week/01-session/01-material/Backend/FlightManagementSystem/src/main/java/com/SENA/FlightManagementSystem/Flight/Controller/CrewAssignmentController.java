package com.SENA.FlightManagementSystem.Flight.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SENA.FlightManagementSystem.Flight.Entity.CrewAssignment;
import com.SENA.FlightManagementSystem.Flight.IService.ICrewAssignmentService;
import com.SENA.FlightManagementSystem.Flight.DTO.CrewAssignmentReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.CrewAssignmentResDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/crew-assignment")
public class CrewAssignmentController extends AFlightBaseController<CrewAssignment, CrewAssignmentReqDto, CrewAssignmentResDto, ICrewAssignmentService> {

    public CrewAssignmentController(ICrewAssignmentService service) {
        super(service, "CrewAssignment");
    }
}