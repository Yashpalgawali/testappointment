package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Appointment;

@Repository("appointrepo")
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

	
	@Query("SELECT a FROM Appointment a WHERE a.vis_email=?1")
	public List<Appointment> findByVis_email(String vis_email);
	
	
	//@Query("SELECT a FROM Appointment a WHERE a.vis_email=:vemail AND a.appoint_date=:today")
	//@Query("SELECT e from Appointment e where e.vis_email =:vemail and e.appoint_date =:today")
	
	@Query(value="SELECT * FROM tbl_appointment a WHERE a.vis_email=:vemail AND a.appoint_date=:today",nativeQuery=true)
	public List<Appointment> getTodaysAppointments(@Param("vemail") String vis_email,@Param("today") String today);
	
}
