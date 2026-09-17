package com.ecomm.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecomm.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = AppException.class)
	public ResponseEntity<?> handleAppException(AppException exception){
		
		ApiResponse<?> resp=new ApiResponse<>(exception.getMessage(),null,exception.getHttpStatus());
		
		return new ResponseEntity<>(resp,exception.getHttpStatus());
	}

}
