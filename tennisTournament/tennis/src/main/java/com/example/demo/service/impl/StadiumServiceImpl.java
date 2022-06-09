package com.example.demo.service.impl;

import com.example.demo.entity.Stadium;
import com.example.demo.repository.StadiumRepository;
import com.example.demo.service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {
    @Autowired
    private final StadiumRepository stadiumRepository;

    @Override
    public List<Stadium> getAll(){
        return stadiumRepository.findAll();
    }

    @Override
    public Stadium saveStadium(Stadium stadium){
        return stadiumRepository.save(stadium);
    }

    @Override
    public Optional<Stadium> findStadiumById(Integer id){
        return stadiumRepository.findById(id);
    }

    @Override
    public void deleteStadiumById(Integer id ){
        stadiumRepository.deleteById(id);
    }
}
