package com.n7.iot.converter;

import com.n7.iot.dto.ParkingDto;
import com.n7.iot.entity.ParkingEntity;
import org.modelmapper.ModelMapper;

public class ParkingConverter {

    public static ParkingDto toDto(ParkingEntity parking) {
        try {
            ParkingDto parkingDto = new ParkingDto();
            parkingDto.setId(parking.getId());
            parkingDto.setStatus(parkingDto.isStatus());
            parkingDto.setTimeOut(parking.getTimeOut());
            parkingDto.setTimeIn(parking.getTimeIn());
            return parkingDto;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
