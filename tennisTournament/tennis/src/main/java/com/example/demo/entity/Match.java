package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate startDate;

    private Integer duration;

    private Integer winnerId;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    @ManyToOne
    private Round round;

    @ManyToOne
    private Stadium stadium;


    public void setWinnerId(Integer winnerId) {
    if (winnerId == player1.getId() || winnerId == player2.getId())
        this.winnerId = winnerId;
    }
}
