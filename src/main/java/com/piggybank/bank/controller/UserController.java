package com.piggybank.bank.controller;

import com.piggybank.bank.dto.request.UserRequestDto;
import com.piggybank.bank.dto.response.UserResponseDto;
import com.piggybank.bank.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    // inject userService dependecy
    @Autowired
    IUserService userService;

    // this end point is for getAllUsers in database
    @GetMapping("/api/v1/users")
    public ResponseEntity<Object> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
        return (ResponseEntity.ok(userResponseDtoList));
    }

    // this end point is for getUserById in database
    @GetMapping("/api/v1/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Integer id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    // this end point if for creating new user in database
    @PostMapping("/api/v1/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/users" + userResponseDto.getId())).body(userResponseDto);
    }

}
