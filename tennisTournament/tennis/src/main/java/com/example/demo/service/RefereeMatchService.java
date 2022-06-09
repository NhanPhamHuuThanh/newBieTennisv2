package com.example.demo.service;

import com.example.demo.entity.RefereeMatch;

import java.util.List;
import java.util.Optional;

public interface RefereeMatchService {
    RefereeMatch save(RefereeMatch refereeMatch);
    List<RefereeMatch> getAll();
    Optional <RefereeMatch> getById(Integer id);
    void deleteById(Integer id);
}
