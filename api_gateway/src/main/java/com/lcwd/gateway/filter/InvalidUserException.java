package com.lcwd.gateway.filter;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String response) {
        super(response);
    }

    public InvalidUserException() {
        super("The credentials you have entered is Invalid");
    }
}
