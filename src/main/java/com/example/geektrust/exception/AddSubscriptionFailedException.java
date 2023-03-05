package com.example.geektrust.exception;

public class AddSubscriptionFailedException extends RuntimeException {

    public AddSubscriptionFailedException() {
    }

    public AddSubscriptionFailedException(String message) {
        super(message);
    }

    public AddSubscriptionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
