package com.incidents.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e) {

        return "Maximum file size (20MB) exceeded!";
    }
}
