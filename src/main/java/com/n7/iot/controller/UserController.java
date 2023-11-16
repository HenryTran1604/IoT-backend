package com.n7.iot.controller;

import com.n7.iot.model.User;
import com.n7.iot.repository.UserRepository;
import jakarta.servlet.ServletOutputStream;
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
    public ResponseEntity<User> Login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User tmp = userRepository.findByUsername(user.getUsername());
        if(tmp != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username đã được sử dụng");
        }
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
