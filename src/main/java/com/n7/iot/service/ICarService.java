package com.n7.iot.service;

import com.n7.iot.dto.CarDto;

import java.util.List;

public interface ICarService {
    List<CarDto> getCarsByUserName(String username);
    CarDto saveCar(CarDto car);
    String deletaCar(String licensePlate);
}
