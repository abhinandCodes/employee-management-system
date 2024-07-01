package com.assesment.employee_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assesment.employee_management_system.dto.DepartmentDTO;
import com.assesment.employee_management_system.entity.Department;
import com.assesment.employee_management_system.entity.Employee;
import com.assesment.employee_management_system.exception.DepartmentNotFoundException;
import com.assesment.employee_management_system.exception.EmployeeException;
import com.assesment.employee_management_system.exception.EmployeeNotFoundException;
import com.assesment.employee_management_system.repository.DepartmentRepository;
import com.assesment.employee_management_system.repository.EmployeeRepository;

@Service
public class DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	private EmployeeRepository employeeRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		super();
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}

	public void createDepartment(DepartmentDTO departmentDto) {
		
		Department department = new Department(departmentDto.getName(), departmentDto.getCreationDate());
		
		if(departmentDto.getDepartmentHeadId() != null) {
			
			Employee deptHeadEmployee = employeeRepository.findByEmployeeId(departmentDto.getDepartmentHeadId());
			
			if(deptHeadEmployee == null ) {
				
				throw new EmployeeNotFoundException("No department Head with this id : " +
						departmentDto.getDepartmentHeadId() + "found ");
				
			}
			
			department.setDepartmentHead(deptHeadEmployee);
			
		}
		
		departmentRepository.save(department);
		
	}

	public void deleteDepartment(Long id) {
		
		Department dept = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("No department found against id"));
		
		List<Employee> employeeList = employeeRepository.findByDepartmentId(id);
		
		if(employeeList.isEmpty()) {
			
			departmentRepository.deleteById(id);
			
		} else {
			
			throw new EmployeeException("This department contains employees");
			
		}
		
	}

	public void updateDepartment(Long id, DepartmentDTO department) {
		
		Department existingDept = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

		existingDept.setName(department.getName());
		existingDept.setCreationDate(department.getCreationDate());

        if (department.getDepartmentHeadId() != null) {
            Employee employee = employeeRepository.findById(department.getDepartmentHeadId())
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
            existingDept.setDepartmentHead(employee);
        }

		departmentRepository.save(existingDept);
		
	}
}
