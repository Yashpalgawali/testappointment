package com.example.demo.controller;

import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Company;
import com.example.demo.service.CompanyService;

@Controller
public class CompanyController {


	
	@Autowired
	CompanyService compserv;
	
	@GetMapping("/addcompany")
	public String addCompany()
	{
		return "AddCompany";
	}
	
	
	@PostMapping("/savecompany")
//	public String saveCompany(@RequestBody Company comp,RedirectAttributes attr)
	public String saveCompany(@ModelAttribute("Company")Company comp,RedirectAttributes attr)
	{
		Company cmpny= compserv.saveCompany(comp);
		if(cmpny!=null)
		{
			return "redirect:/viewcompanies";
		}
		else {
			return "Failed";
		}
	}
	
	@GetMapping("/viewcompanies")
	public String getAllCompanies(Model model)
	{
		List<Company> clist=compserv.getAllCompanies(); 
		model.addAttribute("clist", clist);
		return "ViewCompany";
	}
	
	@GetMapping("/editcompbyid/{id}")
	public String editCompanyById(@PathVariable String id,Model model , RedirectAttributes attr)
	{
		Company comp = compserv.getCompanyByCompId(id);
		if(comp!=null)
		{
			model.addAttribute("comp", comp);
			return "EditCompany";
		}
		else
		{
			attr.addFlashAttribute("reserr", "No Company Found for given Id");
			return "redirect:/viewcompanies";
		}
	}
	
	@PostMapping("/updatecompany")
	public String updateCompany(@ModelAttribute("Company")Company comp,RedirectAttributes attr)
	{
		int res = compserv.updateCompany(comp);
		if(res>0)
		{
			attr.addFlashAttribute("response", "Company is Updated successfully");
			return "redirect:/viewcompanies";
		}
		else
		{
			attr.addFlashAttribute("reserr", "Company is not updated");
			return "redirect:/viewcompanies";
		}
	}
}
