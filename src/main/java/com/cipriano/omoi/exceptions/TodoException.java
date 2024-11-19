package com.cipriano.omoi.exceptions;

public class TodoException extends Exception {

    public TodoException() {

    }

    public TodoException(Throwable cause) {
        super(cause);
    }

    public TodoException(String message) {
        super(message);
    }

    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }

}
