package com.cipriano.omoi.exceptions;

public class UserException extends Exception {

    public UserException() {

    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}
