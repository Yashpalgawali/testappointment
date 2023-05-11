package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Designation;
import com.example.demo.service.DesignationService;

@Controller
public class DesignationController {

	@Autowired
	DesignationService desigserv;
	
	
	@PostMapping("/savedesignation")
	public String saveDesignation(@RequestBody Designation desig)
	{
		Designation desg = desigserv.saveDesignation(desig);
		if(desg!=null)
		{
			return "redirect:/getalldesignations";
		}
		else {
			return "FAILED";
		}
	}
	
	
	@GetMapping("/getalldesignations")
	@ResponseBody
	public List<Designation> getAllDesignations()
	{
		return desigserv.getAllDesignation();
	}
}
