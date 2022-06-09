package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private String phoneNumber;

    private String address;

    private String gender;

    private String firstName;

    private String lastName;
}
