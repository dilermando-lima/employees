package com.project.employees.core.config;

import com.project.employees.core.handle.ApiReturnException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionControllerAdvice {
    

    @ExceptionHandler(ApiReturnException.class)
	public ResponseEntity<ExceptionEntityReturn> exceptionHandlerApiReturnExcepetion(ApiReturnException ex) {
		return new ResponseEntity<ExceptionEntityReturn>(
				new ExceptionEntityReturn( ex.getStatus(), ex.getMessage() ), HttpStatus.valueOf(ex.getStatus()));
	}
    
    
}
