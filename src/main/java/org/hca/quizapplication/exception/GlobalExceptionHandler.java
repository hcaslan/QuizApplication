package org.hca.quizapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(ValidationException ex) {
        ErrorType errorType = ex.getErrorType();
        return new ResponseEntity<>(createErrorMessage(ex),
                errorType.getHttpStatus());
    }

    private ErrorMessage createErrorMessage(ValidationException ex) {
        return ErrorMessage.builder()
                .code(ex.getErrorType().getCode())
                .message(ex.getMessage())
                .build();
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
