package com.example.Spring_boot.repository;

import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Enrollment;
import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.enums.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Long countByCourse(Course course);

    List  <Enrollment> findByStudent(Student student);

    List  <Enrollment> findByStudentAndStatus(Student student, EnrollmentStatus status);
}
