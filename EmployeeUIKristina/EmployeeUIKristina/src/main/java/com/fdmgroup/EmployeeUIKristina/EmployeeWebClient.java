package com.fdmgroup.EmployeeUIKristina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.EmployeeUIKristina.exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeUIKristina.model.Employee;

import reactor.core.publisher.Mono;

@Service
public class EmployeeWebClient {

	private static final String BASE_URI = "/api/v1/employee";

	private WebClient webClient;

	@Autowired
	private EmployeeWebClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Employee postEmployee(Employee employee) {
		return webClient.post().uri(BASE_URI).bodyValue(employee).retrieve().bodyToMono(Employee.class).block();
	}

	public List<Employee> getAllEmployees() {
		return webClient.get().uri(BASE_URI).retrieve().bodyToFlux(Employee.class).collectList().block();
	}

	public Employee getEmployeeById(long id) {
		return webClient.get().uri(builder -> builder.path(BASE_URI + "/" + id).build()).retrieve()
				.onStatus(HttpStatus.NOT_FOUND::equals,
						response -> Mono
								.error(new EmployeeNotFoundException("Employee with ID: " + id + "couldn't be found")))
				.bodyToMono(Employee.class).block();
	}
	
	public Employee updateEmployee (Employee employee) {
		return webClient.put().uri(BASE_URI + "/" + employee.getId()).bodyValue(employee).retrieve().bodyToMono(Employee.class).block();
	}
	
	public void deleteEmployeeById(long id) {
		webClient.delete().uri(BASE_URI + "/" + id).retrieve().toBodilessEntity().block();
	}
}
