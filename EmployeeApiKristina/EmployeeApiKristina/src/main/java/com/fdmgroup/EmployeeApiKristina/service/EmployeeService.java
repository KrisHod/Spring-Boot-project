package com.fdmgroup.EmployeeApiKristina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.EmployeeApiKristina.exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeApiKristina.model.Employee;
import com.fdmgroup.EmployeeApiKristina.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
		Optional<Employee> optFoundEmployee = employeeRepo.findById(id);
		if (optFoundEmployee.isPresent()) {
			return optFoundEmployee.get();
		}
		throw new EmployeeNotFoundException();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(long id, Employee employee) throws EmployeeNotFoundException {
		if (employeeRepo.existsById(id)) {
			employee.setId(id);
			return employeeRepo.save(employee);
		}
		throw new EmployeeNotFoundException("Employee with id " + id + " not found");
	}

	public void deleteEmployee(long id) throws EmployeeNotFoundException {
		if (employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
		} else {
			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}
	}
}
	


