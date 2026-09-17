package com.ecomm.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ApiResponse<T> {
	
	private String message;
	
	private T data;
	
	public ApiResponse(String message, T data, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.data = data;
		this.httpstatus = httpstatus;
	}

	private HttpStatus httpstatus;
	
	

}
