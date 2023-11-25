package com.n7.iot.controller;

import com.n7.iot.dto.CarDto;
import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.CarRepository;
import com.n7.iot.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CarController {
    @Autowired
    private ICarService carService;

    @GetMapping("/cars")
    public List<CarDto> getCarsByUser(@RequestParam("username") String username) {
        return carService.getCarsByUserName(username);
    }
    @PostMapping("/car")
    public CarDto addCar(@RequestBody CarDto car){
        return carService.saveCar(car);
    }
    @DeleteMapping("/car")
    public String deleteCar(@RequestParam("licensePlate") String licensePlate){
        try{
            return carService.deletaCar(licensePlate);
        }
        catch (Exception e){
            return "Xóa xe không thành công";
        }
    }
}
