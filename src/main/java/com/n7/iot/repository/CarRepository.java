package com.n7.iot.repository;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {
    List<CarEntity> findAll();
    CarEntity findByLicensePlate(String licensePlate);
    List<CarEntity> findByUser(UserEntity userEntity);
}
