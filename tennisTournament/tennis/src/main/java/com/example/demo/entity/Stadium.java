package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
@Builder

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stadiumId;

    @Size(max=100)
    private String stadiumName;

    @Size(max=100)
    private String stadiumAddress;

    private Integer seatCapacity;

    @Size(max=100)
    private String stadiumLocation;
}
