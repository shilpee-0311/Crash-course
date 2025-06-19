package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);

    //USE FOR EXCPETION HANDLING
        return optionalValue.orElseThrow(() -> {
            return  new NotFoundException("Student with Id:" +
                    + studentId+ "was not Found.");


        });
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        if (existingStudent == null) {
            return null;
        }

        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        return this.studentRepository.save(existingStudent);

    }

    public void deleteStudentById(Long studentId) {
        this.studentRepository.deleteById(studentId);
    }

}
