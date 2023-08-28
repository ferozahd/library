package com.librarian.book.exception;

public class InvalidConversion extends RuntimeException {

    public InvalidConversion(String message) {
        super(message);
    }

    public InvalidConversion(String message, Throwable cause) {
        super(message, cause);
    }
}