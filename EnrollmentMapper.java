package com.example.Spring_boot.mapper;


import com.example.Spring_boot.dto.CourseDto;
import com.example.Spring_boot.dto.EnrollmentDto;
import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Enrollment;
import com.example.Spring_boot.entities.Mentor;
import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.repository.CourseRepository;
import com.example.Spring_boot.repository.EnrollmentRepository;
import com.example.Spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public EnrollmentMapper(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Enrollment mapToModel(EnrollmentDto dto) {
        Student s = this.studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new NotFoundException("Student with Id: " + dto.getStudentId() + "doesn't exist"));
        Course c = this.courseRepository.findById(dto.getCourseId()).orElseThrow(() -> new NotFoundException("Course with Id: " + dto.getCourseId() + "doesn't exist"));

        Enrollment e = new Enrollment();
   e.setCourse(c);
   e.setStudent(s);
   e.setEnrollmentDate(dto.getEnrollmentDate());
   e.setStatus(dto.getStatus());

return e;


    }
}

