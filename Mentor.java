package com.example.Spring_boot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mentor")
@NoArgsConstructor
@Getter
@Setter
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)

    private long id;

@Column(name="first_name",nullable = false)
@NotBlank(message ="First Name must not be null.")
    private String firstName;

    @Column(name="last_name",nullable = false)
    @NotBlank
    private String lastName;

    @Column(name="current_Company",nullable = false)
    @NotBlank
    private String currentCompany;

    @Column(name="yoe",nullable = false)
    @Min(0)
    @Max(40)
    private  float yearOfExperience;



}
