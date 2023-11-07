package com.example.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.model.Employee;

@Aspect
@Component
public class EmployeeAspect {

	@Before(value = "execution(* com.example.controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Request to "+joinPoint.getSignature()+" Started at "+new Date());
	}
	@After(value = "execution(* com.example.controller.EmployeeController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Request to "+joinPoint.getSignature()+" Ended at "+new Date());
	}
	@Before(value = "execution(* com.example.service.EmployeeServiceImpl.*(..))")
	public void beforeAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to "+joinPoint.getSignature()+" Started at "+new Date());
	}
	@After(value = "execution(* com.example.service.EmployeeServiceImpl.*(..))")
	public void afterAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to "+joinPoint.getSignature()+" Ended at "+new Date());
	}
	@AfterReturning(value = "execution(* com.example.service.EmployeeServiceImpl.addEmployee(..))",returning = "employee")
	public void afterReturningAdvice(JoinPoint joinpoint,Employee employee) {
		System.out.println("Business Logic Run's Successfully to save an Employee With Id:"+employee.getId());
	}
	@AfterThrowing(value = "execution(* com.example.service.EmployeeServiceImpl.addEmployee(..))",throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinpoint,Exception ex) {
		System.out.println("Business Logic to save an employe throws exception:"+ex.getMessage());
	}
}
