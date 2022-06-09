package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDto {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String sponsors;
    private String organizerName;
    private String location;
    private String note;
    private String introduction;
}
