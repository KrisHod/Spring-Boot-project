package com.fdmgroup.EmployeeUIKristina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.EmployeeUIKristina.model.Employee;
import com.fdmgroup.EmployeeUIKristina.service.EmployeeService;

@Controller
public class EmployeeUIController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeUIController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	} 
	
	@GetMapping("/")
	public String toToIndex() {
		return "index";
	}
	
	@GetMapping("/create")
	public String goToCreateEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "create-employee";
	}
	
	@PostMapping("/create")
	public String goToProcessEmployee(Employee employee) {
		Employee createdEmployee = employeeService.creatNewEmployee(employee);
		return "redirect:/view-employee/" + createdEmployee.getId();
		
	}
	
	@GetMapping("/view-employee/{id}")
	public String goToViewEmployeeDetails(@PathVariable long id, Model model) {
		Employee foundEmployee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", foundEmployee);
		return "update-employee";
	}
	
	@GetMapping("/all-employees")
	public String viewAllEmployees(Model model) {
	    List<Employee> employees = employeeService.getAllEmployee();
	    model.addAttribute("employees", employees);
	    return "all-employees";
	}
	
	@PostMapping("/update")
	public String goToProcessEmployeeUpdate(Employee employee, Model model) {
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		model.addAttribute("employee", updatedEmployee);
		return "update-employee";
	}
	
	@GetMapping("/update-employee/{id}")
	public String goToUpdateEmployeeForm(@PathVariable long id, Model model) {
	    Employee existingEmployee = employeeService.getEmployeeById(id);
	    model.addAttribute("employee", existingEmployee);
	    return "update-employee"; 
	}

	
	@GetMapping("/delete/{id}")
	public String goToDeleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployeeById(id);
		return "index";
	}


}
