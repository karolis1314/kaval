package com.registration.kaval.controller;

import com.registration.kaval.dto.UserDto;
import com.registration.kaval.service.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{email}")
    public UserDto findUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

}
