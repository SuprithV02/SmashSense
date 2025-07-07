package com.smashsense.racketservice.exception;

public class RacketNotFoundException extends RuntimeException {
    public RacketNotFoundException(String message) {
        super(message);
    }
}
