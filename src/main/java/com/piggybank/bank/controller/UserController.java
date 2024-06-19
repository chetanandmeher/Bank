package com.piggybank.bank.controller;

import com.piggybank.bank.dto.response.UserResponseDto;
import com.piggybank.bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    // inject userService dependecy
    @Autowired
    IUserService userService;

    // create end point for getAllUsers
    @GetMapping("/api/v1/users")
    public ResponseEntity<Object> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
        return (ResponseEntity.ok(userResponseDtoList));
    }

}
