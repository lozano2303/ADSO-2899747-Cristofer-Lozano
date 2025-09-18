package com.SENA.FlightManagementSystem.Flight.Controller;

import com.SENA.FlightManagementSystem.Flight.Entity.Ticket;
import com.SENA.FlightManagementSystem.Flight.IService.ITicketService;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketResDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ticket")
public class TicketController extends AFlightBaseController<Ticket, TicketReqDto, TicketResDto, ITicketService> {

   public TicketController(ITicketService service) {
       super(service, "Ticket");
   }
}
