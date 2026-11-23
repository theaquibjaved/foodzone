package com.aquib.food_zone.exception;

import com.aquib.food_zone.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlingException(MethodArgumentNotValidException e, HttpServletRequest request){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.timestamp = LocalDateTime.now();
        errorResponse.status = 400;
        errorResponse.error = "Bad Request";
        errorResponse.message = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
        errorResponse.path = request.getRequestURI();

        return ResponseEntity
                .status(400)
                .body(errorResponse);
    }
}
