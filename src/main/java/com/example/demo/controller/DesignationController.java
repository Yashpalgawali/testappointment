package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Designation;
import com.example.demo.service.DesignationService;

@Controller
public class DesignationController {

	@Autowired
	DesignationService desigserv;
	
	
	@GetMapping("/adddesignation")
	public String addDesignation()
	{
		return "AddDesignation";
	}
	
	@PostMapping("/savedesignation")
	public String saveDesignation(@ModelAttribute("Designation") Designation desig,RedirectAttributes attr)
	{
		Designation desg = desigserv.saveDesignation(desig);
		if(desg!=null)
		{
			attr.addFlashAttribute("response", "Designation is saved successfully");
			return "redirect:/getalldesignations";
		}
		else {
			attr.addFlashAttribute("reserr", "Designation is not saved ");
			return "redirect:/getalldesignations";
		}
	}
	
	@GetMapping("/viewdesignation")
	public String viewDesignation(Model model)
	{
		model.addAttribute("dlist", desigserv.getAllDesignation());
		return "ViewDesignation";
	}
	
	@GetMapping("/getalldesignations")
	@ResponseBody
	public List<Designation> getAllDesignations()
	{
		return desigserv.getAllDesignation();
	}
}
