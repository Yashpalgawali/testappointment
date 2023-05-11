package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Appointment;

@Repository("appointrepo")
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

	
	@Query("SELECT a FROM Appointment a WHERE a.vis_email=?1")
	public List<Appointment> findByVis_email(String vis_email);
	
	
	@Query("SELECT a FROM Appointment a WHERE a.vis_email=?1 AND a.appoint_date=?2")
	public List<Appointment> getTodaysAppointments(String vis_email,String today);
	
}
