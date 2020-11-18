package com.project.employees.controller;

import com.project.employees.annotations.AuthType;
import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.entity.ReportAge;
import com.project.employees.entity.ReportSalary;
import com.project.employees.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsController {
    
    @Autowired
    ReportService service;

	@AuthType({AuthType.AUTH_SIMPLE})
	@GetMapping("/employees/age")
	public ResponseEntity<ReportAge> employeesAge() throws ApiReturnException {
		return new ResponseEntity<ReportAge>(service.employeesAge(), HttpStatus.OK); 
	}

	@AuthType({AuthType.AUTH_SIMPLE})
	@GetMapping("/employees/salary")
	public ResponseEntity<ReportSalary> employeesSalary() throws ApiReturnException {
		return new ResponseEntity<ReportSalary>(service.employeesSalary(), HttpStatus.OK); 
	}






}
