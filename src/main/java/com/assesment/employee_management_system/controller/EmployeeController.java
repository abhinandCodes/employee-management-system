package com.assesment.employee_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.employee_management_system.dto.DepartmentDTO;
import com.assesment.employee_management_system.dto.EmployeeDTO;
import com.assesment.employee_management_system.entity.Employee;
import com.assesment.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/test")
	public String test() {
		
		return "API Connection succesfull";
		
	}
	
	@GetMapping("/get/allEmployees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.retrieveAllEmployees();
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDetails) {
		
		employeeService.updateEmployee(id, employeeDetails);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employee) {
		
		employeeService.createEmployee(employee);
		
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PutMapping("/updateDepartment/{employeeId}")
	public ResponseEntity<Employee> updateEmployeeDepartment(@RequestBody DepartmentDTO deptDto ,@PathVariable Long employeeId) {
		
		employeeService.updateEmployeeDepartment(deptDto, employeeId);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
