package com.example.demo.api;

import com.example.demo.entity.Tournament;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.TournamentService;
import com.example.demo.service.dto.TournamentDto;
import com.example.demo.service.mapper.TournamentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(TournamentResource.PATH)
public class TournamentResource {
    public static final String PATH = "/api/tournaments";
    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<TournamentDto>> getAll() {
        return ResponseEntity.ok(TournamentMapper.INSTANCE.toDtos(tournamentService.getAll()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<TournamentDto> getTournamentByName(@PathVariable(value = "name") String name)
            throws ResourceNotFoundException {
        Tournament tournament = tournamentService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found on: " + name));
        return ResponseEntity.ok(TournamentMapper.INSTANCE.toDto(tournament));
    }

    @PostMapping
    public ResponseEntity<TournamentDto> create(@RequestBody Tournament tournament) {
        Tournament tournamentCreated = tournamentService.saveTournament(tournament);
        return ResponseEntity.created(URI.create(TournamentResource.PATH + "/" + tournamentCreated.getName())).body(TournamentMapper.INSTANCE.toDto(tournamentCreated));
    }

    @PutMapping("/{name}")
    public ResponseEntity<TournamentDto> update(@PathVariable(value = "name") String name,
                                                @RequestBody Tournament tournament)
            throws ResourceNotFoundException {
        Tournament tournamentUpdate = tournamentService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found on: " + name));
        tournamentUpdate.setOrganizer(tournament.getOrganizer());
        tournamentUpdate.setStartDate(tournament.getStartDate());
        tournamentUpdate.setEndDate(tournament.getEndDate());
        tournamentUpdate.setSponsors(tournament.getSponsors());
        Tournament saveTournament = tournamentService.saveTournament(tournamentUpdate);
        return ResponseEntity.ok(TournamentMapper.INSTANCE.toDto(saveTournament));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable(value = "name") String name)
            throws ResourceNotFoundException {
        Tournament tournament = tournamentService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found on: " + name));
        tournamentService.deleteById(name);
        return ResponseEntity.noContent().build();
    }
}
