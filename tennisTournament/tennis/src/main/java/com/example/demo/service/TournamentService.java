package com.example.demo.service;

import com.example.demo.entity.Tournament;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    List<Tournament> getAll();

    Tournament saveTournament(Tournament tournament);

    Optional<Tournament> findById(String name);

    void deleteById(String name);

}
