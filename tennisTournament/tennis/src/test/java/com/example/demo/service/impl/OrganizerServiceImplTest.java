package com.example.demo.service.impl;

import com.example.demo.entity.Organizer;
import com.example.demo.service.OrganizerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServiceImplTest {
    @Autowired
    private OrganizerService organizerService;
    @Test
    void deleteOrganizerByName() {
        Organizer organizer= Organizer.builder()
                .name("Alibaba")
                .build();
        organizerService.save(organizer);
        organizerService.deleteById("Alibaba");
        assertEquals(0,organizerService.getAll().size());
    }
}