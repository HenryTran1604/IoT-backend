package com.n7.iot.controller;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @PostMapping("/cars")
    public List<CarEntity> getCarsByUser(@RequestBody UserEntity userEntity) {
        return carRepository.findByUser(userEntity);
    }
}
