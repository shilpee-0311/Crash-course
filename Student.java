package com.example.Spring_boot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)
    private long id;

    @Column(name="first_name",nullable = false)
    @NotBlank(message ="First Name must not be null.")
    private  String firstname;

    @Column(name="last_name",nullable = false)
    @NotBlank(message ="Last Name must not be null.")
    private  String lastname;

    @Column(name="email",nullable= false,unique = true)
    @Email
    private String email;

    @Column(name="password",nullable= false)

    private String password;





}
