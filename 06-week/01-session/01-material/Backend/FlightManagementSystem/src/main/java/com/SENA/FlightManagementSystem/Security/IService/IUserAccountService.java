package com.SENA.FlightManagementSystem.Security.IService;

import com.SENA.FlightManagementSystem.Security.Entity.UserAccount;
import com.SENA.FlightManagementSystem.Security.DTO.UserAccountReqDto;
import com.SENA.FlightManagementSystem.Security.DTO.UserAccountResDto;

public interface IUserAccountService extends ISecurityBaseService<UserAccount, UserAccountReqDto, UserAccountResDto> {
}
