package com.example.Spring_boot.controller;

import com.example.Spring_boot.dto.CourseDto;
import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.mapper.CourseMapper;
import com.example.Spring_boot.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {


    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService,CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper= courseMapper;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto coursedto) {
     Course course = this.courseMapper.mapToModel(coursedto);
            return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);

        }

    }


