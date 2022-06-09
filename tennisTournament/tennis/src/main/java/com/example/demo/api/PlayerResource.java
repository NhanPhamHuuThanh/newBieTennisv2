package com.example.demo.api;

import com.example.demo.entity.Player;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.PlayerService;
import com.example.demo.service.dto.PlayerDto;
import com.example.demo.service.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PlayerResource.PATH)
public class PlayerResource {
    @Autowired
    private PlayerService playerService;
    public static final String PATH = "/api/players";

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAll(){
        return ResponseEntity.ok(PlayerMapper.INSTANCE.toDtos(playerService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> update(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Player player = playerService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        return ResponseEntity.ok(PlayerMapper.INSTANCE.toDto(player));
    }

    @PostMapping
    public ResponseEntity<PlayerDto> add(@RequestBody Player player){
        Player createdPlayer = playerService.save(player);
        return ResponseEntity.created(URI.create(PlayerResource.PATH+"/"+ createdPlayer.getId())).body(PlayerMapper.INSTANCE.toDto(createdPlayer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> update(@PathVariable(value = "id") Integer id,
                                          @RequestBody Player playerDetail) throws ResourceNotFoundException{
        Player player = playerService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        player.setFirstName(playerDetail.getFirstName());
        player.setGender(playerDetail.getGender());
        player.setAddress(playerDetail.getAddress());
        player.setLastName(playerDetail.getLastName());
        player.setPhoneNumber(playerDetail.getPhoneNumber());
        Player playerUpdated = playerService.save(player);
        return ResponseEntity.ok(PlayerMapper.INSTANCE.toDto(playerUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Player player = playerService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
