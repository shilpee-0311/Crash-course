package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Enrollment;
import com.example.Spring_boot.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.ChronoLocalDateTime;

@Service
public class EnrollmentService {


    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    public Enrollment addEnrollment(Enrollment enrollment){
        if(enrollment.getEnrollmentDate().isAfter((ChronoLocalDateTime<?>) enrollment.getCourse())){
               //thrown error
        }

        if(this.enrollmentRepository.countByCourse(enrollment.getCourse())+1
                >= enrollment.getCourse().getCapacity()){

        }
      return   this.enrollmentRepository.save(enrollment);
    }

}
