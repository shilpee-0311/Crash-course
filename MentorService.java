package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {
        return this.mentorRepository.save(mentor);
    }



}




