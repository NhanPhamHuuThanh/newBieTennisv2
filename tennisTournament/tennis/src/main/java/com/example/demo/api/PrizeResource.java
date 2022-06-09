package com.example.demo.api;

import com.example.demo.entity.Prize;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.PrizeService;
import com.example.demo.service.dto.PrizeDto;
import com.example.demo.service.mapper.PrizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PrizeResource.PATH)
public class PrizeResource {
    @Autowired
    private PrizeService prizeService;
    public static final String PATH = "/api/prizes";

    @GetMapping
    public ResponseEntity<List<PrizeDto>> getAll() {
        return ResponseEntity.ok(PrizeMapper.INSTANCE.toDtos(prizeService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrizeDto> getById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Prize prize = prizeService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id does not exist " + id));
        return ResponseEntity.ok(PrizeMapper.INSTANCE.toDto(prize));
    }

    @PostMapping
    public ResponseEntity<PrizeDto> add(@RequestBody Prize prize) {
        Prize prizeCreated = prizeService.save(prize);
        return ResponseEntity.created(URI.create(PrizeResource.PATH + "/" + prizeCreated.getId())).body(PrizeMapper.INSTANCE.toDto(prizeCreated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Prize prize = prizeService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id does not exist " + id));
        prizeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrizeDto> update(@PathVariable(value = "id") Integer id,
                                        @RequestBody Prize prizeDetails) throws ResourceNotFoundException {
        Prize prize = prizeService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id does not exist " + id));
        prize.setId(prizeDetails.getId());
        prize.setPrizeType(prizeDetails.getPrizeType());
        prize.setPrizeAmount(prizeDetails.getPrizeAmount());
        Prize prizeUpdated = prizeService.save(prize);
        return ResponseEntity.ok(PrizeMapper.INSTANCE.toDto(prizeUpdated));
    }
}