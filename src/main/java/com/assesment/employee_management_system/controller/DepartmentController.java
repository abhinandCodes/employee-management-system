package com.assesment.employee_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.employee_management_system.dto.DepartmentDTO;
import com.assesment.employee_management_system.entity.Department;
import com.assesment.employee_management_system.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		
		super();
		
		this.departmentService = departmentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO department ) {
		
		departmentService.createDepartment(department);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
		
		departmentService.deleteDepartment(id);
		
		return ResponseEntity.ok().build();
		
	}
	
}
