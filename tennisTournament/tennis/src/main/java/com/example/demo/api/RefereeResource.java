package com.example.demo.api;


import com.example.demo.entity.Referee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.dto.RefereeDto;
import com.example.demo.service.impl.RefereeServiceImpl;
import com.example.demo.service.mapper.RefereeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(RefereeResource.PATH)
public class RefereeResource {
    @Autowired
    private RefereeServiceImpl refereeService;
    public static final String PATH = "/api/referees";

    @GetMapping
    public ResponseEntity<List<RefereeDto>> getAll(){
        return ResponseEntity.ok(RefereeMapper.INSTANCE.toDtos(refereeService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefereeDto> update(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Referee referee = refereeService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        return ResponseEntity.ok(RefereeMapper.INSTANCE.toDto(referee));

    }

    @PostMapping
    public ResponseEntity<RefereeDto> add(@RequestBody Referee referee){
        Referee createdReferee = refereeService.save(referee);
        return ResponseEntity.created(URI.create(RefereeResource.PATH+"/"+createdReferee.getId())).body(RefereeMapper.INSTANCE.toDto(createdReferee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefereeDto> update(@PathVariable(value = "id") Integer id,
                                          @RequestBody Referee refereeDetails) throws ResourceNotFoundException{
        Referee referee = refereeService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        referee.setName(refereeDetails.getName());
        referee.setAddress(refereeDetails.getAddress());
        referee.setPhoneNumber(refereeDetails.getPhoneNumber());
        Referee refereeUpdated = refereeService.save(referee);
        return ResponseEntity.ok(RefereeMapper.INSTANCE.toDto(refereeUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Referee referee = refereeService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException("Id not found on " + id));
        refereeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
