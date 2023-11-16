package com.n7.iot.repository;

import com.n7.iot.model.Car;
import com.n7.iot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findAll();
    Car findByLicensePlate(String licensePlate);
    List<Car> findByUser(User user);
}
