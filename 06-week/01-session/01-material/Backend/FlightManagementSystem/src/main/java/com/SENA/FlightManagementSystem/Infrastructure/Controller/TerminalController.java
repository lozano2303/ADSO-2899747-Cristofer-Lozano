package com.SENA.FlightManagementSystem.Infrastructure.Controller;

import com.SENA.FlightManagementSystem.Infrastructure.Entity.Terminal;
import com.SENA.FlightManagementSystem.Infrastructure.IService.ITerminalService;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.TerminalReqDto;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.TerminalResDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/terminal")
public class TerminalController extends AInfrastructureBaseController<Terminal, TerminalReqDto, TerminalResDto, ITerminalService> {

    public TerminalController(ITerminalService service) {
        super(service, "Terminal");
    }
}
