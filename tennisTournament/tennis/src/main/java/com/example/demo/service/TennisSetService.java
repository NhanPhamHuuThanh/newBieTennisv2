package com.example.demo.service;

import com.example.demo.api.request.TennisSetRequest;
import com.example.demo.entity.Player;
import com.example.demo.entity.TennisSet;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TennisSetService {

    TennisSet save(TennisSetRequest tennisSetRequest) throws ResourceNotFoundException;

    List<TennisSet> getAll();

    Optional<TennisSet> getById(Integer id);

    void deleteById(Integer id);
    //Check win condition: player with higher score
    TennisSet updateScore(int matchId, int setId, int playerId) throws ResourceNotFoundException;


    int setWinnerCondition(int player1Score, int player2Score);
}
