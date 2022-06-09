package com.example.demo.service.impl;

import com.example.demo.entity.Match;
import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {
    @Autowired
    private final MatchRepository matchRepository;

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match saveMatch(Match match) {
        //check start date here
        matchRepository.save(match);
        return match;
    }

    @Override
    public void deleteMatchById(Integer id) {
    matchRepository.deleteById(id);
    }

    @Override
    public Optional<Match> findById(Integer id) {
        return matchRepository.findById(id);
    }
}
