package com.example.Spring_boot.dto;

import com.example.Spring_boot.entities.Mentor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class CourseDto {

    private String name;

    @Min(0)
    private double price;


    @Min(0)
    private int capacity;

    @Min(3)
    @Max(60)
    private int noOfDays;

    private Date startDate;

    private String description;

    private Mentor mentor;


    private LocalDateTime enrollmentEndDate;


    public Long getMentorId() {
        return  null;
    }

}




