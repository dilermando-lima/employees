package com.project.employees.controller;

import java.util.List;

import com.project.employees.annotations.AuthType;
import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.entity.Employee;
import com.project.employees.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    
    @Autowired
    EmployeeService service;

	@AuthType({AuthType.AUTH_SIMPLE})
	@GetMapping
	public ResponseEntity<List<Employee>> list() throws ApiReturnException {
		return new ResponseEntity<List<Employee>>(service.list(), HttpStatus.OK); 
	}

	@AuthType({AuthType.AUTH_SIMPLE})
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  detail( @PathVariable("id") Long id ) throws ApiReturnException {
		return new ResponseEntity<Employee>(service.detail(id), HttpStatus.OK); 
	}
	
	@AuthType({AuthType.AUTH_SIMPLE})
	@PostMapping
	public ResponseEntity<Employee> create( @RequestBody  Employee employee ) throws ApiReturnException {
		return new ResponseEntity<Employee>(service.create(employee), HttpStatus.CREATED);
	}

	@AuthType({AuthType.AUTH_SIMPLE})
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update( @RequestBody  Employee employee ,  @PathVariable("id") Long id ) throws ApiReturnException {
		return new ResponseEntity<Employee>(service.update(employee, id), HttpStatus.OK);
	}

	@AuthType({AuthType.AUTH_SIMPLE})
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> delete(  @PathVariable("id") Long id ) throws ApiReturnException {
		return new ResponseEntity<Employee>(service.delete( id), HttpStatus.OK);
	}



}
