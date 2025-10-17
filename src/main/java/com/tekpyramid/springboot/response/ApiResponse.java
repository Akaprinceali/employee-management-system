package com.tekpyramid.springboot.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private String message;
    private HttpStatus httpStatus;
    private Object data;

}
