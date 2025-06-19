package com.example.Spring_boot.controller;


import com.example.Spring_boot.dto.EnrollmentDto;
import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Enrollment;
import com.example.Spring_boot.mapper.EnrollmentMapper;
import com.example.Spring_boot.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {


    private final EnrollmentService enrollmentService;
    private final EnrollmentMapper enrollmentMapper;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService,EnrollmentMapper enrollmentMapper) {
        this.enrollmentService = enrollmentService;
        this.enrollmentMapper= enrollmentMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrollment(@RequestBody @Valid EnrollmentDto enrollmentdto){
   Enrollment enrollment = this.enrollmentMapper.mapToModel(enrollmentdto);
        return new ResponseEntity<>(this.enrollmentService.addEnrollment(enrollment), HttpStatus.CREATED);
    }


}
