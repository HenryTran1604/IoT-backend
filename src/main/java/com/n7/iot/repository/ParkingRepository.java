package com.n7.iot.repository;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Integer> {
    List<ParkingEntity> findAll();
    List<ParkingEntity> findByCar(CarEntity carEntity);
    ParkingEntity findByCarAndStatus(CarEntity carEntity, boolean status);
}
