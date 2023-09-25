package com.restoran.service.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restoran.service.payload.MessageResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	public Map<String, String> handleInvalidAurgment(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {

			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return errorMap;

	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	 
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) 
	 public ResponseEntity<MessageResponse> handleException(DuplicateKeyException
	  exception) {
	 
	  //return exception.getMessage(); //return
	 // ResponseEntity.internalServerError().body(new
	 // MessageResponse("Duplicate key exception!.."));
	  //.badRequest() //.body(new
	  //MessageResponse("Error: Username is already taken!"));
	  
	  return ResponseEntity.internalServerError().body(new
	  MessageResponse(exception.getMessage()));
	  
	 }


}
