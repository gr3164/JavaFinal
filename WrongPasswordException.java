package com.example.app;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message){
        super(message);
    }
}