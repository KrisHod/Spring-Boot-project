package com.fdmgroup.EmployeeApiKristina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.EmployeeApiKristina.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
