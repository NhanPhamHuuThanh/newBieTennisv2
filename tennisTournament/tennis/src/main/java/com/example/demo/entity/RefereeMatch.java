package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefereeMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    @ManyToOne
    private Referee referee;

    @JoinColumn
    @ManyToOne
    private Match match;

}
