package com.example.demo.repository;

import com.example.demo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, String> {
//    Optional<Tournament> findTournamentByName(String name);
//    void deleteTournamentByName(String name);
}
