package com.example.Spring_boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name="course")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @NotBlank
    private long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "Price", nullable = false)

    private double price;

    @Column(name = "capacity", nullable = false)

    private int capacity;


    @Column(name = "no_of_days", nullable = false)

    private int noOfDays;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @Column(name = "enrollment_end_date", nullable = false)
    private LocalDateTime enrollmentEndDate;



        @JsonIgnore
        public LocalDate getEndDate() {
            // Convert Date to LocalDate
            LocalDate localStartDate = startDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            // Calculate end date
            return localStartDate.plusDays(noOfDays);

    }
}