package com.sparta.wt.exceptions;

public class ChildNotFoundException extends Exception {

    private String message;

    public ChildNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return ("The Element you were looking for was not found in the Binary Tree: " + message);
    }
}
