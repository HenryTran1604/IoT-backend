package com.n7.iot.repository;

import com.n7.iot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findAll();
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
}
