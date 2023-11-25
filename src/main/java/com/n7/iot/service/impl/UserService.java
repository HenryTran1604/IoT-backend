package com.n7.iot.service.impl;

import com.n7.iot.converter.UserConverter;
import com.n7.iot.dto.UserDto;
import com.n7.iot.entity.UserEntity;
import com.n7.iot.repository.UserRepository;
import com.n7.iot.service.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto getUserByUserName(String username) {
        UserEntity entity = userRepository.findByUsername(username);
        return UserConverter.toDto(entity);
    }
    @Override
    public List<UserDto> getAllUser(){
        List<UserDto> list = new ArrayList<UserDto>();
        List<UserEntity> listEntity = userRepository.findAll();
        for (UserEntity entity : listEntity){
            list.add(UserConverter.toDto(entity));
        }
        return list;
    }

    @Override
    public UserDto findByUsernameAndPassword(String username, String password) {
        UserEntity entity = userRepository.findByUsernameAndPassword(username,password);
        if(entity==null) return null;
        else{
            return UserConverter.toDto(entity);
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity user  = userRepository.findByUsername(userDto.getUsername());
        if(user!= null){
            return null;
        }
        else{
            user = userRepository.save(UserConverter.toEntiy(userDto));
            return UserConverter.toDto(user);
        }
    }

    @Override
    public UserDto editUser(UserDto userDto) {
        UserEntity user = userRepository.findByUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return UserConverter.toDto(user);
    }
}
