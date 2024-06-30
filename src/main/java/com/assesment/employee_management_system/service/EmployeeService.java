package com.assesment.employee_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assesment.employee_management_system.dto.EmployeeDTO;
import com.assesment.employee_management_system.entity.Department;
import com.assesment.employee_management_system.entity.Employee;
import com.assesment.employee_management_system.exception.DepartmentNotFoundException;
import com.assesment.employee_management_system.exception.EmployeeNotFoundException;
import com.assesment.employee_management_system.repository.DepartmentRepository;
import com.assesment.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	private DepartmentRepository departmentRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	public void createEmployee(EmployeeDTO employeeDto) {
		
		Employee employee = new Employee(employeeDto.getName(), employeeDto.getDateOfBirth(), employeeDto.getSalary(),
				employeeDto.getAddress(), employeeDto.getRole(), employeeDto.getJoiningDate(),
				employeeDto.getYearlyBonusPercentage());
		
		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
				.orElseThrow(() -> new DepartmentNotFoundException("No Department found against id :" + employeeDto.getDepartmentId()));

		employee.setDepartment(department);
		
		if(employeeDto.getReportingManagerId() != null) {
			
			Employee reportingManagerEmp = employeeRepository.findByEmployeeId(employeeDto.getReportingManagerId());
			
			if(reportingManagerEmp == null) {
				
				throw new EmployeeNotFoundException("No Reporting manager found against id :" + employeeDto.getReportingManagerId());
				
			} else {
			
				employee.setReportingManager(reportingManagerEmp);
			
			}
			
		}

		employeeRepository.save(employee);
		
	}

	public List<Employee> retrieveAllEmployees() {

		return employeeRepository.findAllEmployees();
		
	}

}
