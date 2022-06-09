package com.example.demo.service;

import com.example.demo.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Player save(Player player);

    List<Player> getAll();

    Optional<Player> getById(Integer id);

    void deleteById(Integer id);
}
