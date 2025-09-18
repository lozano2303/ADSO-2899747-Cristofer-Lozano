package com.SENA.FlightManagementSystem.PassengersServices.Service;

import com.SENA.FlightManagementSystem.PassengersServices.Entity.Passenger;
import com.SENA.FlightManagementSystem.PassengersServices.IRepository.IPassengersServicesBaseRepository;
import com.SENA.FlightManagementSystem.PassengersServices.IRepository.IPassengersServicesPassenger;
import com.SENA.FlightManagementSystem.PassengersServices.IService.IPassengersServicesPassengerService;
import com.SENA.FlightManagementSystem.PassengersServices.DTO.PassengerReqDto;
import com.SENA.FlightManagementSystem.PassengersServices.DTO.PassengerResDto;
import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Security.IService.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServicePassengersServices extends APassengersServicesBaseService<Passenger, PassengerReqDto, PassengerResDto> implements IPassengersServicesPassengerService {

    @Autowired
    private IPassengersServicesPassenger repository;

    @Autowired
    private IPersonService personService;

    @Override
    protected IPassengersServicesBaseRepository<Passenger, String> getRepository() {
        return repository;
    }

    @Override
    public PassengerResDto mapToResDto(Passenger entity) {
        return PassengerResDto.builder()
                .id(entity.getId())
                .frequentFlyerNumber(entity.getFrequentFlyerNumber())
                .personId(entity.getPerson() != null ? entity.getPerson().getId() : null)
                .personName(entity.getPerson() != null ? entity.getPerson().getFirstName() + " " + entity.getPerson().getLastName() : null)
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Passenger mapToEntity(PassengerReqDto dto) {
        Passenger passenger = new Passenger();
        passenger.setFrequentFlyerNumber(dto.getFrequentFlyerNumber());
        passenger.setStatus(dto.getStatus());

        if (dto.getPersonId() != null) {
            try {
                Person person = personService.findById(dto.getPersonId()).orElse(null);
                passenger.setPerson(person);
            } catch (Exception e) {
                // Log error or handle appropriately
                passenger.setPerson(null);
            }
        }

        return passenger;
    }
}
