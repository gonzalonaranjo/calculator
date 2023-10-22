package com.gonzalo.calculator.api;

import com.gonzalo.calculator.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDto> handleMisMatchException(MethodArgumentTypeMismatchException ex) {

        return generateErrorResponse(ex.getMessage(),
                ex.getPropertyName(), Objects.requireNonNull(ex.getValue()).toString());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handleMissingParameterException(MissingServletRequestParameterException ex) {
        return generateErrorResponse(ex.getMessage(), ex.getParameterName());
    }

    private ResponseEntity<ErrorDto> generateErrorResponse(String message, String propertyName) {
        return generateErrorResponse(message, propertyName, null);
    }

    private ResponseEntity<ErrorDto> generateErrorResponse(String message, String propertyName, String value) {
        ErrorDto error = ErrorDto.builder()
                .message(message)
                .propertyName(propertyName)
                .value(value)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
