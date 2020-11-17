package com.project.employees.core.handle;

import org.springframework.http.HttpStatus;

public class ApiReturnException extends Exception {

    private static final long serialVersionUID = 1L;

    private int responseCode;

    private String msg;

    public ApiReturnException (HttpStatus responseCode, String msg) {
		this.msg = msg;
		this.responseCode = responseCode.value();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    
}
