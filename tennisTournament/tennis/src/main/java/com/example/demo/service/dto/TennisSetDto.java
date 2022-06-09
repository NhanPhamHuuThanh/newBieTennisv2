package com.example.demo.service.dto;

import com.example.demo.entity.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TennisSetDto {
    private Integer id;
    private Integer player1Score;
    private Integer player2Score;
    private Integer setWinnerId;
    private Integer setNumber;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer matchId;

    private String player1FirstName;

    private String player2FirstName;

    private String stadiumName;
    private String roundName;
}
