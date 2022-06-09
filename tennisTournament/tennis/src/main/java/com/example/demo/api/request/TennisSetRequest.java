package com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TennisSetRequest {

    private LocalDate startTime;

    private LocalDate endTime;

    private Integer matchId;

}
