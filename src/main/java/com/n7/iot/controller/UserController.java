package com.n7.iot.controller;

import com.n7.iot.dto.UserDto;
import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.UserRepository;
import com.n7.iot.service.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserServices userServices;
    @PostMapping("/login")
    public UserDto Login(@RequestParam String username, @RequestParam String password) {
        UserDto userDto = userServices.findByUsernameAndPassword(username, password);
        return userDto;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUser() {
        return userServices.getAllUser();
    }
    @GetMapping("/user/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userServices.getUserByUserName(username);
    }

    @PostMapping("/user")
    public UserDto addUser(@RequestBody UserDto dto) {

        UserDto tmp = userServices.saveUser(dto);
        if (tmp == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username đã được sử dụng");
        }
        return tmp;
    }
    @PutMapping("/user")
    public UserDto editUser(@RequestBody UserDto dto) {
        UserDto tmp = userServices.editUser(dto);
        if (tmp == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username đã được sử dụng");
        }
        return tmp;
    }

}
