package com.example.demo.service;

import com.example.demo.entity.Round;


import java.util.List;
import java.util.Optional;

public interface RoundService {
    List<Round> getAll();
    Round saveRound(Round round);
    void deleteRoundById(Integer id);
    Optional<Round> findRoundById(Integer id);



}
