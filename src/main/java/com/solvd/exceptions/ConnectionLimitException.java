package com.solvd.exceptions;

public class ConnectionLimitException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Limit of connections";
    }
}
