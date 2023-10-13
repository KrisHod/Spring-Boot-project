package com.fdmgroup.EmployeeUIKristina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.EmployeeUIKristina.EmployeeWebClient;
import com.fdmgroup.EmployeeUIKristina.model.Employee;

@Service
public class EmployeeService {
	
	private EmployeeWebClient employeeClient;

	@Autowired
	public EmployeeService(EmployeeWebClient employeeClient) {
		super();
		this.employeeClient = employeeClient;
	}
	
	public Employee creatNewEmployee(Employee employee) {
		return employeeClient.postEmployee(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeClient.getAllEmployees();
	}
	
	public Employee getEmployeeById(long id) {
		return employeeClient.getEmployeeById(id);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeClient.updateEmployee(employee);
	}
	
	public void deleteEmployeeById(long id) {
		employeeClient.deleteEmployeeById(id);
	}


}
