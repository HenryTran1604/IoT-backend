package com.n7.iot.service.impl;

import com.n7.iot.converter.CarConverter;
import com.n7.iot.dto.CarDto;
import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.ParkingEntity;
import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.CarRepository;
import com.n7.iot.repository.ParkingRepository;
import com.n7.iot.repository.UserRepository;
import com.n7.iot.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParkingRepository parkingRepository;
    @Override
    public List<CarDto> getCarsByUserName(String username) {
        List<CarDto> list = new ArrayList<CarDto>();
        List < CarEntity> carEntityList = carRepository.findByUserName(username);
        for(CarEntity entity : carEntityList){
            list.add(CarConverter.toDto(entity));
        }
        return list;
    }

    @Override
    public CarDto saveCar(CarDto car) {
        CarEntity carEntity = carRepository.findByLicensePlate(car.getLicensePlate());
        if(carEntity!=null) return null;
        else{
            CarEntity carTmp = new CarEntity();
            carTmp.setLicensePlate(car.getLicensePlate());
            carTmp.setModel(car.getModel());
            UserEntity user = userRepository.findByUsername(car.getUsername());
            carTmp.setUser(user);
            CarEntity carResult = carRepository.save(carTmp);
            return CarConverter.toDto(carResult);
        }
    }

    @Override
    public String deletaCar(String licensePlate) {
        List<ParkingEntity> listParking = parkingRepository.findAllParkingByLicensePlateAndMonth(licensePlate,null,null,null);
        parkingRepository.deleteAll(listParking);
        CarEntity carEntity = carRepository.findByLicensePlate(licensePlate);
        carRepository.delete(carEntity);
        return "Xóa xe thành công";
    }

}
