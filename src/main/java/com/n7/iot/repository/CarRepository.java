package com.n7.iot.repository;

import com.n7.iot.entity.CarEntity;
import com.n7.iot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {
    List<CarEntity> findAll();
    CarEntity findByLicensePlate(String licensePlate);
    @Query(value = "SELECT * FROM car where username like %:username%", nativeQuery = true)
    List<CarEntity> findByUserName(@Param("username") String username);
}
