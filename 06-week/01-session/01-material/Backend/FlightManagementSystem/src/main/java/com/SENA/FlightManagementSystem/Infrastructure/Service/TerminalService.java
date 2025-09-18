package com.SENA.FlightManagementSystem.Infrastructure.Service;

import com.SENA.FlightManagementSystem.Infrastructure.Entity.Terminal;
import com.SENA.FlightManagementSystem.Infrastructure.Entity.Airport;
import com.SENA.FlightManagementSystem.Infrastructure.IRepository.ITerminalRepository;
import com.SENA.FlightManagementSystem.Infrastructure.IService.ITerminalService;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.TerminalReqDto;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.TerminalResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService extends AInfrastructureBaseService<Terminal, TerminalReqDto, TerminalResDto> implements ITerminalService {

    @Autowired
    private ITerminalRepository repository;

    @Override
    protected ITerminalRepository getRepository() {
        return repository;
    }

    @Override
    public TerminalResDto mapToResDto(Terminal entity) {
        return TerminalResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .airportId(entity.getAirportId() != null ? entity.getAirportId().getId() : null)
                .airportName(entity.getAirportId() != null ? entity.getAirportId().getName() : null)
                .build();
    }

    @Override
    public Terminal mapToEntity(TerminalReqDto dto) {
        Terminal terminal = new Terminal();
        terminal.setCode(dto.getCode());
        terminal.setName(dto.getName());

        if (dto.getAirportId() != null) {
            Airport airport = new Airport();
            airport.setId(dto.getAirportId());
            terminal.setAirportId(airport);
        }

        return terminal;
    }
}
