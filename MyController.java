package com.example.Spring_boot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

   // @GetMapping("/add_two_number")
   // public int addTwoNumber(
       //     @RequestParam int a,
        //    @RequestParam int b ){
     //   return a+b;

    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }

}
