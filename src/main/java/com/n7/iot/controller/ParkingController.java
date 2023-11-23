package com.n7.iot.controller;

import com.n7.iot.dto.ParkingDto;
import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.ParkingEntity;
import com.n7.iot.repository.CarRepository;
import com.n7.iot.repository.ParkingRepository;
import com.n7.iot.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ParkingController {
    @Autowired
    private IParkingService parkingService;

    @GetMapping("/car/parkings")
    public List<ParkingDto> getParkingsByCar(@RequestParam("licensePlate") Optional<String> licensePlate,
                                                @RequestParam("month")Optional<Integer> month,
                                                @RequestParam("page") Optional<Integer> page,
                                                @RequestParam("year") Optional<Integer> year) {
        List<ParkingDto> parkingDtoList = parkingService.findAllParking(licensePlate.orElse(""), month.orElse(null), page.orElse(0), year.orElse(null));
        return parkingDtoList;
    }

}
