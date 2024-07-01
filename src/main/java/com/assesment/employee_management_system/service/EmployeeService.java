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

	public void updateEmployee(Long id, EmployeeDTO employeeDto) {
		
		Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

		existingEmployee.setName(employeeDto.getName());
        existingEmployee.setDateOfBirth(employeeDto.getDateOfBirth());
        existingEmployee.setSalary(employeeDto.getSalary());
        existingEmployee.setAddress(employeeDto.getAddress());
        existingEmployee.setRole(employeeDto.getRole());
        existingEmployee.setJoiningDate(employeeDto.getJoiningDate());
        existingEmployee.setYearlyBonusPercentage(employeeDto.getYearlyBonusPercentage());

        if (employeeDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                    .orElseThrow(() -> new EmployeeNotFoundException("Department not found"));
            existingEmployee.setDepartment(department);
        }

        if (employeeDto.getReportingManagerId() != null) {
            Employee reportingManager = employeeRepository.findById(employeeDto.getReportingManagerId())
                    .orElseThrow(() -> new EmployeeNotFoundException("Reporting Manager not found"));
            existingEmployee.setReportingManager(reportingManager);
        }
		
		employeeRepository.save(existingEmployee);
		
	}

}
