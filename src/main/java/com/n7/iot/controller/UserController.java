package com.n7.iot.controller;

import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.UserRepository;
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

    @PostMapping("/login")
    public ResponseEntity<UserEntity> Login(@RequestParam String username, @RequestParam String password) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);
        if(userEntity != null) {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
    @GetMapping("/user/{username}")
    public UserEntity getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("/user")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity tmp = userRepository.findByUsername(userEntity.getUsername());
        if(tmp != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username đã được sử dụng");
        }
        userRepository.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);

    }
}
