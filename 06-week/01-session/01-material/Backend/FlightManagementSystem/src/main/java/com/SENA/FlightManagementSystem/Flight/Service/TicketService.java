package com.SENA.FlightManagementSystem.Flight.Service;

import com.SENA.FlightManagementSystem.Flight.Entity.Ticket;
import com.SENA.FlightManagementSystem.Flight.Entity.Flight;
import com.SENA.FlightManagementSystem.Flight.IRepository.ITicketRepository;
import com.SENA.FlightManagementSystem.Flight.IService.ITicketService;
import com.SENA.FlightManagementSystem.Flight.IService.IFlightService;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.TicketResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketRepository repository;

    @Autowired
    private IFlightService flightService;

    @Override
    public List<Ticket> all() throws Exception {
        return repository.findAll();
    }

    @Override
    public List<Ticket> findByStateTrue() throws Exception {
        return repository.findAll().stream()
                .filter(ticket -> ticket.getStatus() != null && ticket.getStatus())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ticket> findById(String id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) throws Exception {
        return repository.save(ticket);
    }

    @Override
    public void update(String id, Ticket ticket) throws Exception {
        Optional<Ticket> existing = repository.findById(id);
        if (existing.isPresent()) {
            ticket.setId(id);
            repository.save(ticket);
        } else {
            throw new Exception("Ticket not found");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public TicketResDto mapToResDto(Ticket entity) {
        return TicketResDto.builder()
                .id(entity.getId())
                .ticketCode(entity.getTicketCode())
                .flightId(entity.getFlightId())
                .passengerId(entity.getPassengerId())
                .ticketClassId(entity.getTicketClassId())
                .seatNumber(entity.getSeatNumber())
                .price(entity.getPrice())
                .status(entity.getStatus())
                .purchaseDate(entity.getPurchaseDate())
                .build();
    }

    @Override
    public Ticket mapToEntity(TicketReqDto dto) {
        Ticket ticket = new Ticket();
        ticket.setTicketCode(dto.getTicketCode());
        ticket.setFlightId(dto.getFlightId());
        ticket.setPassengerId(dto.getPassengerId());
        ticket.setTicketClassId(dto.getTicketClassId());
        ticket.setSeatNumber(dto.getSeatNumber());
        ticket.setPrice(dto.getPrice());
        ticket.setStatus(dto.getStatus());
        ticket.setPurchaseDate(dto.getPurchaseDate());

        return ticket;
    }
}