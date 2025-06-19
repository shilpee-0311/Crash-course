package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.service.MentorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mentor")
public class MentorController {


    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Mentor> addMentor(@RequestBody @Valid Mentor mentor) {
        try {
            Mentor savedMentor = mentorService.addMentor(mentor);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMentor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}