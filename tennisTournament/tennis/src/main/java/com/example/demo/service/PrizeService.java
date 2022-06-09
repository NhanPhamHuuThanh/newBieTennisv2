package com.example.demo.service;

import com.example.demo.entity.Prize;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PrizeService {
    Prize save(Prize prize);

    List<Prize> getAll();

    Optional<Prize> getById(Integer id);

    void deleteById(Integer id);
}
