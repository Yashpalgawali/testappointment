package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Appointment;
import com.example.demo.repository.AppointmentRepo;

@Service("appointserv")
public class AppointmentServImpl implements AppointmentService {

	@Autowired
	AppointmentRepo appointrepo;
	
	@Override
	public Appointment saveAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		return appointrepo.save(appoint);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointrepo.findAll();
	}

	@Override
	public Appointment getAppointmentById(String apid) {
		// TODO Auto-generated method stub
		Long aid = Long.valueOf(apid);
		return appointrepo.findById(aid).get();
	}

	@Override
	public List<Appointment> getAppointmentsByVisEmail(String vemail) {
		// TODO Auto-generated method stub
		try {
			List<Appointment>  alist = appointrepo.findByVis_email(vemail);
			return alist;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Appointment> getAllTodaysAppointmentsByVisEmail(String vemail, String today) {
		// TODO Auto-generated method stub
		try {
			List<Appointment>  tdlist = appointrepo.getTodaysAppointments(vemail, today);
			
			System.err.println("inside todays appoint service \n ");
			
			tdlist.stream().forEach(r->System.err.println(r));
			
			return tdlist;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
