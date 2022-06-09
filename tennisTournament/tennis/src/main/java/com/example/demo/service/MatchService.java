package com.example.demo.service;


import com.example.demo.entity.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    List<Match> getAll();
    Match saveMatch(Match match);
    void deleteMatchById(Integer id);
    Optional<Match> findById(Integer id);
}
