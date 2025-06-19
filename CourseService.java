package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {


    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(Long CourseId) {
      return this.courseRepository.findById(CourseId).orElse(null);
    }






}
