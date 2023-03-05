package com.example.geektrust.exception;

public class InvalidTopupPlanException extends RuntimeException{

    public InvalidTopupPlanException() {
    }

    public InvalidTopupPlanException(String message) {
        super(message);
    }
}
