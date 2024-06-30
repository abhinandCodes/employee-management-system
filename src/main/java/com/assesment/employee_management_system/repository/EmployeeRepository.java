package com.assesment.employee_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assesment.employee_management_system.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e")
	List<Employee> findAllEmployees();

	@Query("SELECT e FROM Employee e WHERE e.id = :id")
	Employee findByEmployeeId(@Param("id") Long id);
	
	List<Employee> findByDepartmentId(Long departmentId);
}
