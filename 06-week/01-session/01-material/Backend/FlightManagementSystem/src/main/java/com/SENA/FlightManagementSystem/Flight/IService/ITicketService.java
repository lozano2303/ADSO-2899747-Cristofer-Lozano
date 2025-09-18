package com.SENA.FlightManagementSystem.Flight.IService;

import com.SENA.FlightManagementSystem.Flight.Entity.Ticket;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketResDto;

public interface ITicketService extends IFlightBaseService<Ticket, TicketReqDto, TicketResDto> {
}
