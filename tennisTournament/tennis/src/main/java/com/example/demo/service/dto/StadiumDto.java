package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumDto {
    private Integer stadiumId;

    private String stadiumName;

    private String stadiumAddress;

    private Integer seatCapacity;

    private String stadiumLocation;

}
