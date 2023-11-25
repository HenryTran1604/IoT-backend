package com.n7.iot.converter;

import com.n7.iot.dto.CarDto;
import com.n7.iot.entity.CarEntity;

public class CarConverter {
    public static CarDto toDto(CarEntity entity){
        CarDto dto = new CarDto();
        dto.setLicensePlate(entity.getLicensePlate());
        dto.setModel(entity.getModel());
        dto.setUsername(entity.getUser().getUsername());
        return dto;
    }
}
