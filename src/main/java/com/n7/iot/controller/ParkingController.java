package com.n7.iot.controller;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.ParkingEntity;
import com.n7.iot.repository.CarRepository;
import com.n7.iot.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ParkingController {
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private CarRepository carRepository;

    @PostMapping("/car/parkings")
    public List<ParkingEntity> getParkingsByCar(@RequestParam("licensePlate") String licensePlate) {
        CarEntity carEntity = carRepository.findByLicensePlate(licensePlate);
        return carEntity.getParkings();
    }
}
