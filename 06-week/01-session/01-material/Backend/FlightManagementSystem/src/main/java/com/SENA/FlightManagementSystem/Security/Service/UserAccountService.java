package com.SENA.FlightManagementSystem.Security.Service;

import com.SENA.FlightManagementSystem.Security.Entity.UserAccount;
import com.SENA.FlightManagementSystem.Security.Entity.Person;
import com.SENA.FlightManagementSystem.Security.Entity.Role;
import com.SENA.FlightManagementSystem.Security.DTO.UserAccountReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.UserAccountResDto;
import com.SENA.FlightManagementSystem.Security.DTO.PersonResDto;
import com.SENA.FlightManagementSystem.Security.DTO.RoleResDto;
import com.SENA.FlightManagementSystem.Security.IRepository.IUserAccountRepository;
import com.SENA.FlightManagementSystem.Security.IService.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends ASecurityBaseService<UserAccount, UserAccountReqDto, UserAccountResDto> implements IUserAccountService {

    @Autowired
    private IUserAccountRepository repository;

    @Override
    protected IUserAccountRepository getRepository() {
        return repository;
    }

    @Override
    public UserAccountResDto mapToResDto(UserAccount entity) {
        UserAccountResDto dto = new UserAccountResDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());

        if (entity.getPersonId() != null) {
            PersonResDto personDto = new PersonResDto();
            personDto.setId(entity.getPersonId().getId());
            personDto.setFirstName(entity.getPersonId().getFirstName());
            personDto.setLastName(entity.getPersonId().getLastName());
            personDto.setDocumentNumber(entity.getPersonId().getDocumentNumber());
            dto.setPerson(personDto);
        }

        if (entity.getRoleId() != null) {
            RoleResDto roleDto = new RoleResDto();
            roleDto.setId(entity.getRoleId().getId());
            roleDto.setName(entity.getRoleId().getName());
            roleDto.setDescription(entity.getRoleId().getDescription());
            dto.setRole(roleDto);
        }

        return dto;
    }

    @Override
    public UserAccount mapToEntity(UserAccountReqDto dto) {
        UserAccount entity = new UserAccount();
        entity.setUsername(dto.getUsername());
        // Note: Password should be hashed before saving
        // entity.setPasswordHash(hashPassword(dto.getPassword()));

        // Person and Role would need to be fetched from repositories
        // This is a simplified version - in real implementation you'd inject repositories
        return entity;
    }
}
