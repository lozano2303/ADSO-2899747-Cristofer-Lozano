package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Security.IRepository.IPersonRepository;
import com.SENA.FlightManagementSystem.Security.IService.IPersonService;
import com.SENA.FlightManagementSystem.Security.DTO.PersonReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.PersonResDto;
import com.SENA.FlightManagementSystem.Parameterization.Entity.DocumentType;
import com.SENA.FlightManagementSystem.Parameterization.IService.IDocumentTypeService;
import com.SENA.FlightManagementSystem.Geolocation.Entity.City;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends ASecurityBaseService<Person, PersonReqDto, PersonResDto> implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Autowired
    private IDocumentTypeService documentTypeService;

    @Autowired
    private ICityService cityService;

    @Override
    protected IPersonRepository getRepository() {
        return repository;
    }

    @Override
    public PersonResDto mapToResDto(Person entity) {
        return PersonResDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .documentNumber(entity.getDocumentNumber())
                .birthDate(entity.getBirthDate())
                .gender(entity.getGender())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .attendantName(entity.getAttendantName())
                .attendingPhone(entity.getAttendingPhone())
                .documentTypeId(entity.getDocumentTypeId() != null ? entity.getDocumentTypeId().getId() : null)
                .documentTypeName(entity.getDocumentTypeId() != null ? entity.getDocumentTypeId().getName() : null)
                .cityId(entity.getCityId() != null ? entity.getCityId().getId() : null)
                .cityName(entity.getCityId() != null ? entity.getCityId().getName() : null)
                .build();
    }

    @Override
    public Person mapToEntity(PersonReqDto dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setDocumentNumber(dto.getDocumentNumber());
        person.setBirthDate(dto.getBirthDate());
        person.setGender(dto.getGender());
        person.setPhone(dto.getPhone());
        person.setEmail(dto.getEmail());
        person.setAddress(dto.getAddress());
        person.setAttendantName(dto.getAttendantName());
        person.setAttendingPhone(dto.getAttendingPhone());

        if (dto.getDocumentTypeId() != null) {
            try {
                DocumentType documentType = documentTypeService.findById(dto.getDocumentTypeId()).orElse(null);
                person.setDocumentTypeId(documentType);
            } catch (Exception e) {
                person.setDocumentTypeId(null);
            }
        }

        if (dto.getCityId() != null) {
            try {
                City city = cityService.findById(dto.getCityId()).orElse(null);
                person.setCityId(city);
            } catch (Exception e) {
                person.setCityId(null);
            }
        }

        return person;
    }
}
