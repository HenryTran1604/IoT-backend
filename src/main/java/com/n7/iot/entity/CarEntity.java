package com.n7.iot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
public class CarEntity {
    @Id
    @Column(name = "licensePlate", nullable = false)
    private String licensePlate;

    private String model;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "car")
    List<ParkingEntity> parkingEntities;
}
