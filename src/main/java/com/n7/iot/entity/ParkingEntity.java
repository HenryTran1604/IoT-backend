package com.n7.iot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parking")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkingId")
    private int id;

    private boolean status;

    @Column(name = "timeIn", columnDefinition = "datetime")
    private Timestamp timeIn;
    @Column(name = "timeOut", columnDefinition = "datetime")
    private Timestamp timeOut;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "licensePlate", referencedColumnName = "licensePlate")
    private CarEntity car;
}
