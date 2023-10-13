package com.fdmgroup.EmployeeApiKristina.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.EmployeeApiKristina.exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeApiKristina.model.Employee;
import com.fdmgroup.EmployeeApiKristina.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Operation(summary = "Create a new employee")
	@ApiResponse(responseCode = "201", description = "Employee created successfully")
	@ApiResponse(responseCode = "400", description = "Invalid input")
	@PostMapping()
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(location).body(createdEmployee);

	}

	@Operation(summary = "Get an employee by ID")
	@ApiResponse(responseCode = "200", description = "Employee found and returned")
	@ApiResponse(responseCode = "404", description = "Employee not found for the given ID")
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(id);
	}

	@Operation(summary = "It returns all employees")
	@ApiResponse(description = "Returns all employees", responseCode = "200", content = {
			@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) })
	@GetMapping()
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@Operation(summary = "Update an employee by ID")
	@ApiResponse(responseCode = "200", description = "Employee updated successfully")
	@ApiResponse(responseCode = "404", description = "Employee not found")
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
			throws EmployeeNotFoundException {
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@Operation(summary = "Delete an employee by ID")
	@ApiResponse(responseCode = "204", description = "Employee deleted successfully")
	@ApiResponse(responseCode = "404", description = "Employee not found for the given ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}
