package com.example.demo.service.impl;

import com.example.demo.entity.RefereeMatch;
import com.example.demo.repository.RefereeMatchRepository;
import com.example.demo.service.RefereeMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeMatchServiceImpl implements RefereeMatchService {
    @Autowired
    private RefereeMatchRepository refereeMatchRepository;

    @Override
    public RefereeMatch save(RefereeMatch refereeMatch) {
        refereeMatchRepository.save(refereeMatch);
        return refereeMatch;
    }

    @Override
    public List<RefereeMatch> getAll() {
        return refereeMatchRepository.findAll();
    }

    @Override
    public Optional<RefereeMatch> getById(Integer id) {
        return refereeMatchRepository.findById(id);
    }


    @Override
    public void deleteById(Integer id) {
        refereeMatchRepository.deleteById(id);
    }
}
