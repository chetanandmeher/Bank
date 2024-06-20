package com.piggybank.bank.service.impl;

import com.piggybank.bank.dto.request.UserRequestDto;
import com.piggybank.bank.dto.response.UserResponseDto;
import com.piggybank.bank.mysql.model.Account;
import com.piggybank.bank.mysql.model.User;
import com.piggybank.bank.repository.AccountRepository;
import com.piggybank.bank.repository.UserRepository;
import com.piggybank.bank.service.IUserService;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public List<UserResponseDto> getAllUsers() {
        // get the list of all users from the database
        Iterable<User> users = userRepository.findAll();
        // convert user list to list of UserResponseDto
        List<UserResponseDto> userResponseDtoList = new ArrayList<UserResponseDto>();
        for (User user : users) {
            userResponseDtoList.add(convertUserToUserResponseDto(user));
        }
        return userResponseDtoList;
    }

    // method to retrieve user by given id
    @Override
    public UserResponseDto getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return convertUserToUserResponseDto(user.get());
        } else {
            System.out.println("User with id " + id + "not found");
            return new UserResponseDto();
        }
    }

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        /* Below code save data in users table */
        User user = convertUserRequestDtoToUser(userRequestDto);
        user.setCreatedBy(1);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        /* This code will save data in accounts table */
        // Retrieve the user just saved from the database because we need the user Id generated
        // to save it in the accounts table.
        User savedUser = userRepository.findUserByUsername(userRequestDto.getUsername());
        Account account = convertUserRequestDtoToAccount(userRequestDto,savedUser);
        account.setCreatedBy(1);
        account.setCreatedAt(LocalDateTime.now());
        System.out.println();
        System.out.println("Newly Created account: " + account);
        System.out.println();
        accountRepository.save(account);

        // return userResponseDto of the new user just created
        return convertUserToUserResponseDto(savedUser);
    }

    // this will convert user model to userResponseDto
    private UserResponseDto convertUserToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .build();
    }

    // this will convert userRequestDto to user model
    private User convertUserRequestDtoToUser(UserRequestDto userRequestDto) {
        return User.builder()
                .username(userRequestDto.getUsername())
                .firstName(userRequestDto.getFirstName())
                .middleName(userRequestDto.getMiddleName())
                .lastName(userRequestDto.getLastName())
                .dob(userRequestDto.getDob())
                .email(userRequestDto.getEmail())
                .gender(userRequestDto.getGender())
                .build();
    }

    // this will convert userRequestDto to account model
    private Account convertUserRequestDtoToAccount(UserRequestDto userRequestDto, User user) {
        Account account = Account.builder()
                            .userId(user.getId())
                            .name(userRequestDto.getAccountName())
                            .type(userRequestDto.getAccountType())
                            .rateOfInterest(userRequestDto.getRateOfInterest())
                            .build();
        // we have check that 'balance' field is filled by the User or not
        // if filled we have to set the given value otherwise will not set it
        if (userRequestDto.getBalance() != null) {
            account.setBalance(userRequestDto.getBalance());
        }
        return account;
    }
}
