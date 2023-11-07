package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> fetchAllEmployees(){
		return new ResponseEntity<>(service.getAllEmployees(),HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployees(@RequestBody Employee emp) throws Exception{
		return new ResponseEntity<>(service.addEmployee(emp),HttpStatus.OK);
	}
}
