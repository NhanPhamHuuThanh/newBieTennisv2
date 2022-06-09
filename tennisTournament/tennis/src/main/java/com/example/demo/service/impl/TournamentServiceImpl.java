package com.example.demo.service.impl;

import com.example.demo.entity.Tournament;
import com.example.demo.repository.TournamentRepository;
import com.example.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentServiceImpl implements TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;


    @Override
    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament saveTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
        return tournament;
    }

    @Override
    public Optional<Tournament> findById(String name) {
        return tournamentRepository.findById(name);
    }

    @Override
    public void deleteById(String name) {
        tournamentRepository.deleteById(name);
    }
}
