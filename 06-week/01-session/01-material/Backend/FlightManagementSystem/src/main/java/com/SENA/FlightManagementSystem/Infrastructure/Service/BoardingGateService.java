package com.SENA.FlightManagementSystem.Infrastructure.Service;

import com.SENA.FlightManagementSystem.Infrastructure.Entity.BoardingGate;
import com.SENA.FlightManagementSystem.Infrastructure.Entity.Terminal;
import com.SENA.FlightManagementSystem.Infrastructure.IRepository.IBoardingGateRepository;
import com.SENA.FlightManagementSystem.Infrastructure.IService.IBoardingGateService;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.BoardingGateReqDto;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.BoardingGateResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardingGateService extends AInfrastructureBaseService<BoardingGate, BoardingGateReqDto, BoardingGateResDto> implements IBoardingGateService {

    @Autowired
    private IBoardingGateRepository repository;

    @Override
    protected IBoardingGateRepository getRepository() {
        return repository;
    }

    @Override
    public BoardingGateResDto mapToResDto(BoardingGate entity) {
        return BoardingGateResDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .terminalId(entity.getTerminalId() != null ? entity.getTerminalId().getId() : null)
                .terminalName(entity.getTerminalId() != null ? entity.getTerminalId().getName() : null)
                .build();
    }

    @Override
    public BoardingGate mapToEntity(BoardingGateReqDto dto) {
        BoardingGate boardingGate = new BoardingGate();
        boardingGate.setCode(dto.getCode());
        boardingGate.setName(dto.getName());

        if (dto.getTerminalId() != null) {
            Terminal terminal = new Terminal();
            terminal.setId(dto.getTerminalId());
            boardingGate.setTerminalId(terminal);
        }

        return boardingGate;
    }
}
