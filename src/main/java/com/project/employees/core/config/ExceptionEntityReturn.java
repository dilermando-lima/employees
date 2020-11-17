package com.project.employees.core.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionEntityReturn {

    @JsonProperty("response_code")
    private int responseCode;
	private String msg;

    public ExceptionEntityReturn(int responseCode, String msg) {
        this.responseCode = responseCode;
        this.msg = msg;
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
