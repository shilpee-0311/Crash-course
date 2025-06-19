package com.example.Spring_boot.mapper;

import com.example.Spring_boot.dto.CourseDto;
import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.repository.MentorRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final MentorRepository mentorRepository;

    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto) {
        Course c = new Course();
        Mentor m = this.mentorRepository.findById(dto.getMentorId()).orElseThrow(() -> new NotFoundException("Cannot find mentor with Id:" + dto.getMentorId()));
        c.setName(dto.getName());
        c.setPrice(dto.getPrice());
        c.setCapacity(dto.getCapacity());
        c.setNoOfDays(dto.getNoOfDays());
        c.setStartDate(dto.getStartDate());
        c.setDescription(dto.getDescription());
        c.setMentor(m);
        c.setEnrollmentEndDate(dto.getEnrollmentEndDate());

        return c;
    }
}
