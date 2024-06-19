package com.piggybank.bank.service;

import com.piggybank.bank.dto.response.UserResponseDto;

public interface IUserService {

    public UserResponseDto getAllUsers(); // this will return list of all users
}
