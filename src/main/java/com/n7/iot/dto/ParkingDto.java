package com.n7.iot.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class ParkingDto {
    private int id;
    private boolean status;
    private Timestamp timeIn;
    private Timestamp timeOut;
    private Double parkingTime;
    private Double fee;
}
