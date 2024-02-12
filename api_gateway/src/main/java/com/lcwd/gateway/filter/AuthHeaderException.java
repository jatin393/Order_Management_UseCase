package com.lcwd.gateway.filter;

public class AuthHeaderException extends Throwable {
    public AuthHeaderException() {
        super("Missing Authorization Header.");
    }
    public AuthHeaderException(String authHeader) {
        super(authHeader);
    }
}
