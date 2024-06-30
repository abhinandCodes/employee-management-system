package com.assesment.employee_management_system.controller;

import com.assesment.employee_management_system.entity.Employee;
import com.assesment.employee_management_system.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
E
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "")
    public Employee createEmployee(@RequestBody Employee employee) €€€€€€€€€€€€€€€€€€€€{

        Employee savedEmp = employeeService.createEmployee(employee);

óí€€    }
}
