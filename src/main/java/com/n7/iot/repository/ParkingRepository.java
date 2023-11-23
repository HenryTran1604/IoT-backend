package com.n7.iot.repository;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.ParkingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Integer> {
    List<ParkingEntity> findAll();
    ParkingEntity findByCarAndStatus(CarEntity carEntity, boolean status);
    @Query(value = "select * from car_parking.parking where licensePlate like %:licensePlate% " +
            " and (timeOut between :monthStart and :monthEnd)", nativeQuery = true)
    List<ParkingEntity> findAllParkingByLicensePlateAndMonth(@Param("licensePlate") String licensePlate,
                                                             @Param("monthStart") String monthStart,
                                                             @Param("monthEnd") String monthEnd,
                                                             Pageable pageable);
}
