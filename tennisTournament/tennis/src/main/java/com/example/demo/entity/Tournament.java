package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Builder

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tournament {

    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private String sponsors;

    @ManyToOne
    @JoinColumn
    private Organizer organizer;

}
