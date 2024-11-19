package com.cipriano.omoi.exceptions;

public class TodoListException extends Exception {

    public TodoListException() {

    }

    public TodoListException(Throwable cause) {
        super(cause);
    }

    public TodoListException(String message) {
        super(message);
    }

    public TodoListException(String message, Throwable cause) {
        super(message, cause);
    }

}
