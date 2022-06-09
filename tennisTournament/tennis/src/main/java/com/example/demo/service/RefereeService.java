package com.example.demo.service;

import com.example.demo.entity.Prize;
import com.example.demo.entity.Referee;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

public interface RefereeService {
    Referee save(Referee referee);
    List<Referee> getAll();
    Optional<Referee> getById(Integer id);
    void deleteById(Integer id);
}
