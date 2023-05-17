package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service("empserv")
public class EmployeeServImpl implements EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return emprepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Override
	public Employee getEmployeByEmpId(String id) {
		// TODO Auto-generated method stub
		Long eid = Long.valueOf(id);
		
		return emprepo.findById(eid).get();
	}

	@Override
	public void deleteEmployeeByEmpId(String empid) {
		// TODO Auto-generated method stub
		Long eid = Long.valueOf(empid);
		
		emprepo.deleteById(eid);
	}

	@Override
	public Employee getempbyemail(String email) {
		// TODO Auto-generated method stub
		return emprepo.getEmpByEmailId(email);
	}

}
