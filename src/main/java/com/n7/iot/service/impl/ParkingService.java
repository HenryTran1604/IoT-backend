package com.n7.iot.service.impl;

import com.n7.iot.controller.ParkingController;
import com.n7.iot.converter.ParkingConverter;
import com.n7.iot.dto.ParkingDto;
import com.n7.iot.entity.ParkingEntity;
import com.n7.iot.repository.ParkingRepository;
import com.n7.iot.service.IParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService implements IParkingService {

    @Autowired
    private ParkingRepository parkingRepository;
    @Override
    public List<ParkingDto> findAllParking(String licensePlate, Integer month, Integer page, Integer year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        YearMonth yearMonth = YearMonth.of(year, month);
        String start = null;
        String end = null;
        if(month != null && year != null) {
            LocalDateTime dateStart = yearMonth.atDay(1).atStartOfDay();
            LocalDateTime dateEnd  = yearMonth.atEndOfMonth().atTime(23, 59, 59);
            start = dateStart.format(formatter);
            end = dateEnd.format(formatter);
        }
        System.out.println("Ngày đầu tiên " + start);
        System.out.println("Ngày kết thúc " + end);
        Pageable pageable = PageRequest.of(page, 10);
        List<ParkingEntity> listParking = parkingRepository.findAllParkingByLicensePlateAndMonth(licensePlate, start, end, pageable);
        List<ParkingDto> listParkingDto = new ArrayList<>();
        for(ParkingEntity parking : listParking) {
            Long time = parking.getTimeOut().getTime() - parking.getTimeIn().getTime();
            double totalTime = time.doubleValue() / 3600000;
            System.out.println("Time " + time);
            ParkingDto parkingDto = ParkingConverter.toDto(parking);
            parkingDto.setParkingTime(totalTime);
            parkingDto.setFee(totalTime * 10000);
            listParkingDto.add(parkingDto);
        }
        return listParkingDto;
    }
}
