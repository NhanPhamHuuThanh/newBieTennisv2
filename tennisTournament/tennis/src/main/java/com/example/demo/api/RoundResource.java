package com.example.demo.api;

import com.example.demo.entity.Round;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.RoundService;
import com.example.demo.service.dto.RoundDto;
import com.example.demo.service.mapper.RoundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(RoundResource.PATH)
public class RoundResource {
    @Autowired
    private RoundService roundService;

    public static final String PATH = "/api/round";

    @GetMapping
    public ResponseEntity<List<RoundDto>> getAll(){
        return ResponseEntity.ok(RoundMapper.INSTANCE.toDtos(roundService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoundDto> getById(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException {
        Round round = roundService.findRoundById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found:" + id));
        return ResponseEntity.ok(RoundMapper.INSTANCE.toDto(round));
    }

    @PostMapping
    public ResponseEntity<RoundDto> create(@RequestBody Round round){
        Round createdRound = roundService.saveRound(round);
        return ResponseEntity.created(URI.create(RoundResource.PATH + "/" + createdRound.getRoundName())).body(RoundMapper.INSTANCE.toDto(createdRound));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoundDto> update(@PathVariable(value = "id")Integer id,
                                        @RequestBody Round roundDetail)
            throws ResourceNotFoundException{
        Round roundUpdate = roundService.findRoundById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
        roundUpdate.setRoundName(roundDetail.getRoundName());
        roundUpdate.setRoundType(roundDetail.getRoundType());

        Round saveRound = roundService.saveRound(roundUpdate);
        return ResponseEntity.ok(RoundMapper.INSTANCE.toDto(saveRound));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException{
        Round round = roundService.findRoundById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
        roundService.deleteRoundById(id)
        ;
        return ResponseEntity.noContent().build();
    }
}