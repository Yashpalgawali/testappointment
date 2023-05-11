package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_employee")
public class Employee {
	
	@Id
	@SequenceGenerator(name = "emp_seq" , initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "emp_seq" , strategy = GenerationType.AUTO)
	private Long emp_id;
	
	private String emp_name;
	
	private String emp_email;
	
	private String emp_contact;
	
	@OneToOne(cascade = CascadeType.MERGE,targetEntity = Designation.class)
	@JoinColumn(name = "desig_id",referencedColumnName = "desig_id")
	private Designation designation;
	
	
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = Department.class)
	@JoinColumn(name = "dept_id" , referencedColumnName = "dept_id")
	private Department department;
}
