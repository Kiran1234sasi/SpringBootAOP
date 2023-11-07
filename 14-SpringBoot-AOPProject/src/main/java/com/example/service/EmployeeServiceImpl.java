package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp)throws Exception{
		if(emp.getName().length() > 5 ) 
			throw new Exception("Reduce Your Length of Name");
		return repo.save(emp);
		
	}

}
