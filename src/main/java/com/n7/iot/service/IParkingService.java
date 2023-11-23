package com.n7.iot.service;

import com.n7.iot.dto.ParkingDto;

import java.util.List;

public interface IParkingService {

    List<ParkingDto> findAllParking(String licensePlate, Integer month, Integer page, Integer year);
}
