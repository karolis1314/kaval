package com.registration.kaval.service;

import com.registration.kaval.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findUserById(Long id);
    void saveUser(UserDto userDto);

    UserDto findUserByEmail(String string);

    List<UserDto> findAllUser();
}
