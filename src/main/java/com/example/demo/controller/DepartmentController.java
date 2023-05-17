package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Department;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentController {

	
	@Autowired
	DepartmentService deptserv;
	
	@Autowired
	CompanyService compserv;
	
	@GetMapping("/adddepartment")
	public String addDepartment(Model model)
	{
		model.addAttribute("clist", compserv.getAllCompanies());
		return "AddDepartment";
	}
	
	@PostMapping("/savedepartment")
	public String saveDepartment(@RequestBody Department dept)
	{
		Department depart = deptserv.saveDepartment(dept);
		
		if(depart!=null)
		{
			return "redirect:/getalldepartments";
		}
		else
		{
			return "Failed";
		}
	}

	@GetMapping("/getalldepartments")@ResponseBody
	public List<Department> getAllDepartments()
	{
		return deptserv.getAllDepartments();
	}
	
	
	@GetMapping("/viewdepartment")
	public String viewDepartments(Model model)
	{
		model.addAttribute("clist", compserv.getAllCompanies());
		return "ViewDepartments";
	}
	
	@GetMapping("/getdeptbyid/{id}")
	@ResponseBody
	public Department getDeptbyid(@PathVariable("id") String id)
	{
		return deptserv.getDepartmentById(id);
	}
	
	@GetMapping("/getdeptbycompid/{id}")
	@ResponseBody
	public List<Department> getDeptbyCompid(@PathVariable("id") String compid)
	{
		return deptserv.getDepartmentByCompId(compid);
	}
	
	@PutMapping("/updatedept")
	public String updateDepartment(@RequestBody Department dept)
	{
		int val = deptserv.updateDepartment(dept) ;
		if(val>0)
		{
			return "redirect:/getalldepartments";
		}
		else {
			return "FAILED";
		}
		
	}
}
