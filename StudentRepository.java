package com.example.Spring_boot.repository;

import com.example.Spring_boot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
