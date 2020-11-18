package com.project.employees.core.handle;

import org.springframework.http.HttpStatus;

public class ApiReturnException extends Exception {

    private static final long serialVersionUID = 1L;

    private int status;

    private String message;

    public ApiReturnException (HttpStatus status, String message) {
		this.message = message;
		this.status = status.value();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  
    
    
}
