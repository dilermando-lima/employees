package com.project.employees.controller;

import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    

    @Autowired
	AuthService service;
	
    @GetMapping("/key-access")
	public ResponseEntity<String> getKeyAccess() throws ApiReturnException {
		return new ResponseEntity<String>(service.getKeyAccess(), HttpStatus.OK); 
    }
    
}
