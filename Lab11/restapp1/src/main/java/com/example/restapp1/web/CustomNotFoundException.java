package com.example.restapp1.web;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String msg) {
        super(msg);
    }
}