package com.example.demo.service.impl;

import com.example.demo.entity.Round;
import com.example.demo.repository.RoundRepository;
import com.example.demo.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {
    @Autowired
    private final RoundRepository roundRepository;

    @Override
    public List<Round> getAll() {
        return roundRepository.findAll();
    }

    @Override
    public Round saveRound(Round round) {
        roundRepository.save(round);
        return round;
    }

    @Override
    public void deleteRoundById(Integer id) {
        roundRepository.deleteById(id);
    }

    @Override
    public Optional<Round> findRoundById(Integer id) {
        return roundRepository.findById(id);
    }
}
