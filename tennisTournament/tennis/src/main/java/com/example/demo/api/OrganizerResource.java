package com.example.demo.api;

import com.example.demo.entity.Organizer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.OrganizerService;
import com.example.demo.service.dto.OrganizerDto;
import com.example.demo.service.mapper.OrganizerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(OrganizerResource.PATH)

public class OrganizerResource {
    @Autowired
    private OrganizerService organizerService;

    public static final String PATH = "/api/organizers";

    @GetMapping
    public ResponseEntity<List<OrganizerDto>> getAll() {
        return ResponseEntity.ok(OrganizerMapper.INSTANCE.toDtos(organizerService.getAll()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<OrganizerDto> getOrganizerByName(@PathVariable(value = "name") String name)
            throws ResourceNotFoundException {
        Organizer organizer = organizerService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found on: " + name));
        return ResponseEntity.ok(OrganizerMapper.INSTANCE.toDto(organizer));
    }

    @PostMapping
    public ResponseEntity<OrganizerDto> create(@RequestBody Organizer organizer) {
        Organizer createdOrganizer = organizerService.save(organizer);
        return ResponseEntity.created(URI.create(OrganizerResource.PATH + "/" + createdOrganizer.getName())).body(OrganizerMapper.INSTANCE.toDto(createdOrganizer));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable(value = "name") String name) throws ResourceNotFoundException {
        Organizer organizer = organizerService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found on: " + name));
        organizerService.deleteById(name);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<OrganizerDto> update(@PathVariable(value = "name") String name, @RequestBody Organizer organizerDetail) throws ResourceNotFoundException {
        Organizer editOrganizer = organizerService.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found on: " + name));
        editOrganizer.setAddress(organizerDetail.getAddress());
        editOrganizer.setPhoneNumber(organizerDetail.getPhoneNumber());
        Organizer saveOrganizer = organizerService.save(editOrganizer);
        return ResponseEntity.ok(OrganizerMapper.INSTANCE.toDto(saveOrganizer));
    }
}
