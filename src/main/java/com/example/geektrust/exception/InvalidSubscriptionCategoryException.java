package com.example.geektrust.exception;

public class InvalidSubscriptionCategoryException extends RuntimeException{
    public InvalidSubscriptionCategoryException() {
    }

    public InvalidSubscriptionCategoryException(String message) {
        super(message);
    }
}
