package com.SENA.FlightManagementSystem.Flight.Service;

import com.SENA.FlightManagementSystem.Flight.Entity.Baggage;
import com.SENA.FlightManagementSystem.Flight.Entity.Ticket;
import com.SENA.FlightManagementSystem.Flight.IRepository.IBaggageRepository;
import com.SENA.FlightManagementSystem.Flight.IService.IBaggageService;
import com.SENA.FlightManagementSystem.Flight.IService.ITicketService;
import com.SENA.FlightManagementSystem.Flight.DTO.BaggageReqDto;
import com.SENA.FlightManagementSystem.Flight.DTO.BaggageResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BaggageService implements IBaggageService {

    @Autowired
    private IBaggageRepository repository;

    @Autowired
    private ITicketService ticketService;

    @Override
    public List<Baggage> all() throws Exception {
        return repository.findAll();
    }

    @Override
    public List<Baggage> findByStateTrue() throws Exception {
        return repository.findAll().stream()
                .filter(baggage -> baggage.getStatus() != null && baggage.getStatus())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Baggage> findById(String id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public Baggage save(Baggage baggage) throws Exception {
        return repository.save(baggage);
    }

    @Override
    public void update(String id, Baggage baggage) throws Exception {
        Optional<Baggage> existing = repository.findById(id);
        if (existing.isPresent()) {
            baggage.setId(id);
            repository.save(baggage);
        } else {
            throw new Exception("Baggage not found");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public BaggageResDto mapToResDto(Baggage entity) {
        return BaggageResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .weight(entity.getWeight())
                .ticketId(entity.getTicket() != null ? entity.getTicket().getId() : null)
                .ticketCode(entity.getTicket() != null ? entity.getTicket().getTicketCode() : null)
                .build();
    }

    @Override
    public Baggage mapToEntity(BaggageReqDto dto) {
        Baggage baggage = new Baggage();
        baggage.setCode(dto.getCode());
        baggage.setName(dto.getName());
        baggage.setDescription(dto.getDescription());
        baggage.setStatus(dto.getStatus());
        baggage.setWeight(dto.getWeight());

        if (dto.getTicketId() != null) {
            try {
                Optional<Ticket> ticket = ticketService.findById(dto.getTicketId());
                baggage.setTicket(ticket.orElse(null));
            } catch (Exception e) {
                baggage.setTicket(null);
            }
        }

        return baggage;
    }
}