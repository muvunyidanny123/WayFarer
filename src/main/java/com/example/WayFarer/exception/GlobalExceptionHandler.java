package com.example.WayFarer.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public String handleApiException(ApiException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "An error occurred: " + ex.getMessage();
    }
}
