package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Appointment;

public interface AppointmentService {

	public Appointment saveAppointment(Appointment appoint);
	
	public List<Appointment> getAllAppointments();
	
	public Appointment getAppointmentById(String apid);

	public List<Appointment> getAppointmentsByVisEmail(String vemail);
	
	public List<Appointment> getAllTodaysAppointmentsByVisEmail(String vemail, String today);
	
}
