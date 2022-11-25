package com.example.springbootbackend.exception;

public class LogNotFoundException extends RuntimeException {
    public LogNotFoundException(Integer id) {
        super("Could not find 'log' with id=" + id);
    }
}
