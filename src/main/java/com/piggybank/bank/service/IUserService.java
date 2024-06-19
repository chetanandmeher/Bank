package com.piggybank.bank.service;

import com.piggybank.bank.dto.response.UserResponseDto;

import java.util.List;

public interface IUserService {

    public List<UserResponseDto> getAllUsers(); // this will return list of all users
}
