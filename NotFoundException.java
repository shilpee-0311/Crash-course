package com.example.Spring_boot.exception;



public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
