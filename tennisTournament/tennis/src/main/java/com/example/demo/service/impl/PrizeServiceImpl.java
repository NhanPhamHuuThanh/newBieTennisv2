package com.example.demo.service.impl;

import com.example.demo.entity.Prize;
import com.example.demo.repository.PrizeRepository;
import com.example.demo.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeRepository prizeRepository;

    @Override
    public Prize save(Prize prize) {
        prizeRepository.save(prize);
        return prize;
    }

    @Override
    public List<Prize> getAll() {
        return prizeRepository.findAll();
    }

    @Override
    public Optional<Prize> getById(Integer id) {
        return prizeRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        prizeRepository.deleteById(id);
    }
}
