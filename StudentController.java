/*
    @GetMapping("/student/{sId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name="sId") long studentId) {
     /*  USE FOR STATUS CODE 200 AND 400
     try{
          C
      }catch(NotFoundException e) {
          return new ResponseEntity<>(Map.of("message",e.getMessage()), HttpStatus.NOT_FOUND);
      }

        try {
            Student student = this.studentService.getStudentById(studentId);
            return new ResponseEntity<>(student, HttpStatus.OK);
            // GENERIC EXCEPTION HANDLE
             }catch(NotFoundException e){
               return new ResponseEntity<>(Map.of("message",e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());  //internalServerError =500
        }
    }

     }

 */

package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Student;
import com.example.Spring_boot.exception.NotFoundException;
import com.example.Spring_boot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody @Valid Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/{sId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "sId") long studentId) {
        try {
            Student student = this.studentService.getStudentById(studentId);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        try {
            if (studentId != student.getId()) {
                return ResponseEntity.badRequest().body(Map.of("message", "The ID in the path and body must match"));
            }
            Student updatedStudent = this.studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable long studentId) {
        try {
            this.studentService.deleteStudentById(studentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}








