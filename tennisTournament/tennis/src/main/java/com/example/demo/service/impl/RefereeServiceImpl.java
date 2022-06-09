package com.example.demo.service.impl;

import com.example.demo.entity.Referee;
import com.example.demo.repository.RefereeRepository;
import com.example.demo.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeServiceImpl implements RefereeService {
    @Autowired
    RefereeRepository refereeRepository;

    @Override
    public Referee save(Referee referee) {
        refereeRepository.save(referee);
        return referee;
    }

    @Override
    public List<Referee> getAll() {
        return refereeRepository.findAll();
    }

    @Override
    public Optional<Referee> getById(Integer id) {
        return refereeRepository.findById(id);
    }


    @Override
    public void deleteById(Integer id) {
    refereeRepository.deleteById(id);
    }
}
