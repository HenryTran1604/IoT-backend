package com.n7.iot.repository;

import com.n7.iot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
