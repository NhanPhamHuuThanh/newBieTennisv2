package com.example.demo.api;

import com.example.demo.entity.RefereeMatch;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.dto.RefereeMatchDto;
import com.example.demo.service.impl.RefereeMatchServiceImpl;
import com.example.demo.service.mapper.RefereeMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(RefereeMatchResource.PATH)
public class RefereeMatchResource {
    @Autowired
    private RefereeMatchServiceImpl refereeMatchService;
    public static final String PATH = "/api/refereematchs";

    @GetMapping
    public ResponseEntity<List<RefereeMatchDto>> getAll(){
        return ResponseEntity.ok(RefereeMatchMapper.INSTANCE.toDtos(refereeMatchService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefereeMatchDto> getById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        RefereeMatch refereeMatch = refereeMatchService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        return ResponseEntity.ok(RefereeMatchMapper.INSTANCE.toDto(refereeMatch));
    }

    @PostMapping
    public ResponseEntity<RefereeMatchDto> add(@RequestBody RefereeMatch refereeMatch){
        RefereeMatch createdRefereeMatch = refereeMatchService.save(refereeMatch);
        return ResponseEntity.created(URI.create(RefereeMatchResource.PATH+"/"+createdRefereeMatch.getId())).body(RefereeMatchMapper.INSTANCE.toDto(createdRefereeMatch));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefereeMatchDto> update(@PathVariable(value = "id") Integer id,
                                               @RequestBody RefereeMatch refereeMatchDetails) throws ResourceNotFoundException{
        RefereeMatch refereeMatchUpdate = refereeMatchService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        refereeMatchUpdate.setId(refereeMatchDetails.getId());
        refereeMatchUpdate.setMatch(refereeMatchDetails.getMatch());
        refereeMatchUpdate.setReferee(refereeMatchDetails.getReferee());
        RefereeMatch saveRefereeMatch = refereeMatchService.save(refereeMatchUpdate);
        return ResponseEntity.ok(RefereeMatchMapper.INSTANCE.toDto(saveRefereeMatch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RefereeMatch> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException{
        RefereeMatch refereeMatch = refereeMatchService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        refereeMatchService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
