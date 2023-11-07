package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee emp) throws Exception;

}
