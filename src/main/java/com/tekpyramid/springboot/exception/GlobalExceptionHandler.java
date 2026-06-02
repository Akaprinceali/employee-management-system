package com.tekpyramid.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import com.tekpyramid.springboot.response.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import com.tekpyramid.springboot.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException exception){

        Map<String,String> errors=new HashMap<>();

        for(FieldError fieldError: exception.getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    
    @ExceptionHandler(InputMismatchException.class)
    public ResponseEntity<ApiResponse> inputMismatchExceptionHandler(InputMismatchException exception){
        ApiResponse response = new ApiResponse();
        String msg = exception.getMessage() != null ? exception.getMessage() : "Invalid input provided";
        response.setMessage(msg);
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
        response.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> runtimeExceptionHandler(RuntimeException exception){
        ApiResponse response = new ApiResponse();
        response.setMessage(exception.getMessage());
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setData(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
