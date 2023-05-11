package com.example.demo.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_appointment")
public class Appointment {

	@Id
	@SequenceGenerator(name = "appoint_seq",allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "appoint_seq")
	private Long appoint_id;
	
	private String vis_name;
	
	private String vis_email;
	
	private String vis_contact;
	
	private String vis_comp;
	
	private String vis_address;
	
	private Date   appoint_date;
	
	private String appoint_time;
	
	private String vis_purpose;
	
	private String status;
	
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Employee.class)
	@JoinColumn(name = "emp_id" , referencedColumnName = "emp_id")
	private Employee employee;
	
	
} 
