package com.example.geektrust.exception;

public class InvalidDateException extends RuntimeException {

    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }
}
