package com.piggybank.bank.service;

import com.piggybank.bank.dto.request.UserRequestDto;
import com.piggybank.bank.dto.response.UserResponseDto;

import java.util.List;

public interface IUserService {

    public List<UserResponseDto> getAllUsers(); // this will return list of all users
    public UserResponseDto getUserById(Integer id); // this will return user with provided id
    public UserResponseDto createUser(UserRequestDto userRequestDto); // this will create user in database.

}
