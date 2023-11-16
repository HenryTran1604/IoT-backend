package com.n7.iot.repository;

import com.n7.iot.model.Car;
import com.n7.iot.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    List<Parking> findAll();
    List<Parking> findByCar(Car car);
    Parking findByCarAndStatus(Car car, boolean status);
}
