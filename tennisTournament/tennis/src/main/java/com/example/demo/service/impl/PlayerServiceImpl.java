package com.example.demo.service.impl;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player save(Player player) {
        playerRepository.save(player);
        return player;
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getById(Integer id) {
        return playerRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
    playerRepository.deleteById(id);
    }
}
