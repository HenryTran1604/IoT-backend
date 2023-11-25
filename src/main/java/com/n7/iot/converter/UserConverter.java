package com.n7.iot.converter;

import com.n7.iot.dto.UserDto;
import com.n7.iot.entity.UserEntity;

public class UserConverter {
    public static UserDto toDto(UserEntity entity){
        try {
            UserDto userDto = new UserDto();
            userDto.setUsername(entity.getUsername());
            userDto.setEmail(entity.getEmail());
            userDto.setFullName(entity.getFullName());
            userDto.setRole(entity.getRole());
            return userDto;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static UserEntity toEntiy(UserDto dto){
        try{
            UserEntity entity = new UserEntity();
            entity.setUsername(dto.getUsername());
            entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());
            entity.setFullName(dto.getFullName());
            entity.setRole(dto.getRole());
            return entity;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
