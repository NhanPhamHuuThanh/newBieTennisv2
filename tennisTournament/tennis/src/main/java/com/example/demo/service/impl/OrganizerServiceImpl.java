package com.example.demo.service.impl;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;
import com.example.demo.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> getAll() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer save(Organizer organizer) {
       return organizerRepository.save(organizer);
    }

    @Override
    public Optional<Organizer> findById(String name) {
        return organizerRepository.findById(name);
    }


    @Override
    public void deleteById(String name) {
        organizerRepository.deleteById(name);
    }
}
