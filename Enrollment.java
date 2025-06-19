package com.example.Spring_boot.entities;

import com.example.Spring_boot.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="enrollment")
@Getter
@Setter
public class Enrollment {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name="student_id",nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id",nullable = false)
    private Course course;


    @Column(name="enrollment_id",nullable = false)
    private LocalDateTime enrollmentDate;

    @Column(name="status",nullable = false)
    private CourseStatus status = CourseStatus.ACTIVE;



}
