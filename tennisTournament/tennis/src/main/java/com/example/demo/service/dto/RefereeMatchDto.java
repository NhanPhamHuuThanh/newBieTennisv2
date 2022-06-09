package com.example.demo.service.dto;

import com.example.demo.entity.Match;
import com.example.demo.entity.Referee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefereeMatchDto {

    private String refereeName;

    private LocalDate matchStartDate;

    private Integer matchDuration;

    private String player1FirstName;

    private String player2FirstName;

    private Integer matchWinnerId;
}
