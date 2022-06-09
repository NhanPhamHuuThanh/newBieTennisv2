package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Organizer {

    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;
}
