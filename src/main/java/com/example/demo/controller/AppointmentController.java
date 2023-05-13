package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.Appointment;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

@Controller
public class AppointmentController {

	@Autowired
	AppointmentService appointserv;
	
	@Autowired
	CompanyService compserv;
	
	@Autowired
	DepartmentService deptserv;
	
	@Autowired
	EmployeeService empserv;
	
	@GetMapping("/bookappointment")
	public String bookAppointment(Model model)
	{
		model.addAttribute("elist", empserv.getAllEmployees());
		return "BookAppointment";
	}
	
	// Following can be used for REST call
//	@PostMapping("/saveappointment")
//	public String saveAppointment(@RequestBody Appointment appoint)
//	{
//		Appointment app = appointserv.saveAppointment(appoint);
//		if(app!=null)
//		{
//			return "redirect:/getallappoints";
//		}
//		else {
//			return null;
//		}
//	}
	
	// Following can be used for REST call
//	@GetMapping("/getallappoints")@ResponseBody
//	public List<Appointment> getAllAppointments()
//	{
//		return appointserv.getAllAppointments();
//	}
	
	@PostMapping("/saveappointment")
	public String saveAppointment(@ModelAttribute("Appointment")Appointment appoint,RedirectAttributes attr)
	{
		Appointment app = appointserv.saveAppointment(appoint);
		if(app!=null)
		{
			attr.addFlashAttribute("response", "Appointment is booked successfully. Waiting for the confirmations");
			return "redirect:/viewallappointments";
		}
		else {
			attr.addFlashAttribute("reserr", "Appointment is not booked ");
			return "redirect:/viewallappointments";
		}
	}
	
	@GetMapping("/viewallappointments")
	public String viewAllAppointments(Model model)
	{
		List<Appointment> aplist =appointserv.getAllAppointments(); 
		
		model.addAttribute("aplist", aplist);
		return "ViewAppointments"; 
	}

	
	@GetMapping("/searchappointment")
	public String searchAppointment()
	{
		return "SearchAppointment";
	}
	
	@RequestMapping("/getallappointmentsbyemail/{vemail}")
	@ResponseBody
	public List<Appointment> getAllAppointmentsByVisEmail( @PathVariable("vemail")String vemail)
	{
		 return appointserv.getAppointmentsByVisEmail(vemail);
	}
	
	
	@RequestMapping("/gettodaysappointmentsbyemail/{vemail}")
	@ResponseBody
	public List<Appointment> getTodaysAppointmentsByVisEmail( @PathVariable("vemail")String vemail)
	{
		LocalDate tday = LocalDate.now();
		String today = String.valueOf(tday);
		System.err.println("Todays date is ->> "+today);
		
		List<Appointment> tlist = appointserv.getAllTodaysAppointmentsByVisEmail(vemail, today);
		
		return tlist;
	}
	
	@RequestMapping("/searchappointbyemail")
	public String searchAppointmentByEmail(@ModelAttribute("Appointment")Appointment appoint,Model model,RedirectAttributes attr)
	{
		String baseurl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		
		model.addAttribute("vemail", appoint.getVis_email());
		model.addAttribute("burl", baseurl);
		
		return "ViewAppointmentsByEmail";
		
//		List<Appointment> aplist =appointserv.getAppointmentsByVisEmail(appoint.getVis_email());
//		aplist.stream().forEach(e->System.err.println(e));
//		if(aplist.size()>0)
//		{
//			model.addAttribute("aplist", aplist);
//			return "ViewAppointmentsByEmail";
//		}
//		else
//		{
//			attr.addFlashAttribute("reserr", "No Appointment found for given Email "+appoint.getVis_email());
//			return "redirect:/viewallappointments";
//		}
	}
}
