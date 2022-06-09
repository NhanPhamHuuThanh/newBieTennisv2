package com.example.demo.service.dto;

import com.example.demo.entity.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDto {

    private Integer id;

    private String roundName;

    private String roundType;

    private String tournamentName;

    private LocalDate tournamentStartDate;

    private LocalDate tournamentEndDate;

}
