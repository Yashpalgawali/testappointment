package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;

@Repository("emprepo")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
	@Query("SELECT e FROM Employee e WHERE e.emp_email=:email")
	public Employee getEmpByEmailId(String email);
}
