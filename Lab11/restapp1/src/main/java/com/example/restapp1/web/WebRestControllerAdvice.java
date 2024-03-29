package com.example.restapp1.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseMsg handleNotFoundException(CustomNotFoundException ex) {
        ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
        return responseMsg;
    }
}