package com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRequest {

    private LocalDate startDate;
    private Integer duration;
    private Integer winnerId;
    private Integer player1Id;
    private Integer player2Id;
    private Integer roundId;
    private Integer stadiumId;
}
