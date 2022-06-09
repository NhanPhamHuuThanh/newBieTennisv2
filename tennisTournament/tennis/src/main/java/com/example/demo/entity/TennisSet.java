package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Builder

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class TennisSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer player1Score;

    private Integer player2Score;

    private Integer setWinnerId;

    private Integer setNumber;

    private LocalDate startTime;

    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Enumerated(value = EnumType.STRING)
    private SetStatus setStatus;

}
