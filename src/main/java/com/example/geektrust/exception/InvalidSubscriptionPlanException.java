package com.example.geektrust.exception;

public class InvalidSubscriptionPlanException extends RuntimeException{

    public InvalidSubscriptionPlanException() {
    }

    public InvalidSubscriptionPlanException(String message) {
        super(message);
    }
}
