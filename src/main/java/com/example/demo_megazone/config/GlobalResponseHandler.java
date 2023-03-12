package com.example.demo_megazone.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalResponseHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllException(Exception e){
        e.printStackTrace();
        Map<String,String> body = new HashMap<>();
        body.put("msg", e.getMessage());
        return ResponseEntity.internalServerError().body(body);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public final ResponseEntity HttpServerErrorException(HttpServerErrorException e){
        e.printStackTrace();
        Map<String,String> body = new HashMap<>();
        body.put("msg", e.getStatusText());
        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}
