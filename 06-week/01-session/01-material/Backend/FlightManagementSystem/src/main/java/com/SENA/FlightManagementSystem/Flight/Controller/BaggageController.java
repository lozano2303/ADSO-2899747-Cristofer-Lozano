package com.SENA.FlightManagementSystem.Flight.Controller;
import com.SENA.FlightManagementSystem.Flight.Entity.Baggage;
import com.SENA.FlightManagementSystem.Flight.IService.IBaggageService;
import com.SENA.FlightManagementSystem.Flight.DTO.BaggageReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.BaggageResDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/baggage")
public class BaggageController extends AFlightBaseController<Baggage, BaggageReqDto, BaggageResDto, IBaggageService> {

   public BaggageController(IBaggageService service) {
       super(service, "Baggage");
   }

}
