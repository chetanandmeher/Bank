package com.piggybank.bank.service.impl;

import com.piggybank.bank.dto.response.UserResponseDto;
import com.piggybank.bank.mysql.model.User;
import com.piggybank.bank.repository.AccountRepository;
import com.piggybank.bank.repository.UserRepository;
import com.piggybank.bank.service.IUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// mark @Service to denote this is service layer
@Service
public class UserService implements IUserService {

    // inject the userRepository dependency
    @Autowired
    UserRepository userRepository;

    // inject`the accountRepository dependency
    @Autowired
    AccountRepository accountRepository;

    // method to get all the users in database
    @Override
    public UserResponseDto getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        // convert user list to list of UserResponseDto

        return null;
    }

    private UserResponseDto convertUserToUserResponseDto(User user) {
        UserResponseDto.builder()
                .id(user.getId())
                .fullName(user.getFirstName() + user.getMiddleName() + user.getLastName())
                .username(user.getUsername())
                .build();
    }
}
