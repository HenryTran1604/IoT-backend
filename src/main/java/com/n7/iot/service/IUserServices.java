package com.n7.iot.service;

import com.n7.iot.dto.UserDto;

import java.util.List;

public interface IUserServices {
    UserDto getUserByUserName(String username);
    List<UserDto> getAllUser();
    UserDto findByUsernameAndPassword(String username,String password);
    UserDto saveUser(UserDto userDto);
    UserDto editUser(UserDto userDto);
}
