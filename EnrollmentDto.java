package com.example.Spring_boot.dto;


import com.example.Spring_boot.entities.Course;
import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.enums.CourseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EnrollmentDto {
    private long studentId;

    private long courseId;
    private LocalDateTime enrollmentDate;
    private CourseStatus status = CourseStatus.ACTIVE;


}
