package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empserv;
	
	@PostMapping("/saveemployee")
	public String saveEmployee(@RequestBody Employee emp)
	{
		Employee empl = empserv.saveEmployee(emp);
		
		if(empl!=null)
		{
			return "redirect:/getallemployees";
		}
		else {
			return "FAILED";
		}
	}
	
	@GetMapping("/getallemployees")@ResponseBody
	public List<Employee> getAllEmployees()
	{
		return empserv.getAllEmployees();
	}
	
	@DeleteMapping("/delempbyid/{id}")
	public List<Employee> deleteEmployeeByEmpid(@PathVariable("id") String id)
	{
		empserv.deleteEmployeeByEmpId(id);
		return empserv.getAllEmployees();
	}
	
	@GetMapping("/getempbyid/{id}")@ResponseBody
	public Employee getEmployeeByEmpId(@PathVariable String id)
	{
		Employee emp = empserv.getEmployeByEmpId(id);
		if(emp!=null)
		{
			return emp;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/getdeptbyempid/{id}")
	@ResponseBody
	public List<Employee> getDepartmentByEmpId(@PathVariable("id") String id)
	{
		return List.of(empserv.getEmployeByEmpId(id));
	}
	
}
