package com.example.geektrust.exception;

public class AddTopupFailedException extends RuntimeException {

    public AddTopupFailedException() {
    }

    public AddTopupFailedException(String message) {
        super(message);
    }
}
