package com.example.demo.service.impl;

import com.example.demo.api.request.TennisSetRequest;
import com.example.demo.entity.Match;
import com.example.demo.entity.Player;
import com.example.demo.entity.TennisSet;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TennisSetRepository;
import com.example.demo.service.MatchService;
import com.example.demo.service.PlayerService;
import com.example.demo.service.TennisSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TennisSetServiceImpl implements TennisSetService {
    @Autowired
    TennisSetRepository tennisSetRepository;
    @Autowired
    MatchService matchService;
    @Autowired
    PlayerService playerService;

    @Override
    public TennisSet save(TennisSetRequest tennisSetRequest) throws ResourceNotFoundException {
        TennisSet tennisSet = new TennisSet();
        tennisSet.setPlayer1Score(0);
        tennisSet.setPlayer2Score(0);
        tennisSet.setSetNumber(tennisSetRequest.getSetNumber());
        tennisSet.setStartTime(tennisSetRequest.getStartTime());
        tennisSet.setEndTime(tennisSetRequest.getEndTime());
        TennisSet tennisSetSave=tennisSetRepository.save(tennisSet);
        return tennisSetSave;
    }

    @Override
    public List<TennisSet> getAll() {
        return tennisSetRepository.findAll();
    }

    @Override
    public Optional<TennisSet> getById(Integer id) {
        return tennisSetRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        tennisSetRepository.deleteById(id);
    }

    @Override
    public TennisSet updateScore(int matchId, int setId, int playerId) throws ResourceNotFoundException {
        Match currentMatch = matchService.findById(matchId).orElseThrow(() -> new ResourceNotFoundException("Id of match is not found"));
        TennisSet currentSet = tennisSetRepository.findById(setId).orElseThrow(() -> new ResourceNotFoundException("Id of set is not found"));
        TennisSet updatedSet = null;
        if (validationForUpdatingScore(currentMatch, currentSet)) {
          updatedSet= tennisSetRepository.save(updateScoreForPlayer(currentMatch, currentSet, playerId));
        }
        return updatedSet;
    }

    public boolean validationForUpdatingScore(Match match, TennisSet tennisSet) throws ResourceNotFoundException {
        if (match.getWinnerId() == null) {
            if (tennisSet.getSetWinnerId() == null)
                return true;
            else
                throw new ResourceNotFoundException("Set already have a winner");
        } else
            throw new ResourceNotFoundException("Match already have a winner");
    }

    public TennisSet updateScoreForPlayer(Match match, TennisSet tennisSet, int id) throws ResourceNotFoundException {
        if (match.getPlayer1().getId() == id) {
            tennisSet.setPlayer1Score(tennisSet.getPlayer1Score() + 1);
            setWinnerId(tennisSet, match);
        } else if (match.getPlayer2().getId() == id) {
            tennisSet.setPlayer2Score(tennisSet.getPlayer2Score() + 1);
            setWinnerId(tennisSet, match);
        } else
            throw new ResourceNotFoundException("Player id does not exist");
        return tennisSet;
    }

    @Override
    public int setWinnerCondition(int player1Score, int player2Score) {
        if (player1Score >= 4 &&
                player1Score - player2Score >= 2)
            return 1;
        else if (player2Score >= 4 &&
                player2Score - player1Score >= 2)
            return 2;
        else
            return 0;
    }

    public void setWinnerId(TennisSet tennisSet, Match match) {
        int i = setWinnerCondition(tennisSet.getPlayer1Score(), tennisSet.getPlayer2Score());
        if (i == 1)
            tennisSet.setSetWinnerId(match.getPlayer1().getId());
        else if (i == 2)
            tennisSet.setSetWinnerId(match.getPlayer2().getId());

    }


    public boolean isPlayer1Win(int player1Score, int player2Score) {
        return player1Score >= 4 &&
                player1Score - player2Score >= 2;

    }

    public boolean isPlayer2Win(int player1Score, int player2Score) {
        return player2Score >= 4 &&
                player2Score - player1Score >= 2;

    }

    public Player getPlayer1(TennisSetRequest tennisSetRequest) throws ResourceNotFoundException {
        return matchService.findById(tennisSetRequest.getMatchId()).orElseThrow(() -> new ResourceNotFoundException("Match not found!")).getPlayer1();
    }

    public Player getPlayer2(TennisSetRequest tennisSetRequest) throws ResourceNotFoundException {
        return matchService.findById(tennisSetRequest.getMatchId()).orElseThrow(() -> new ResourceNotFoundException("Match not found!")).getPlayer2();
    }
}
