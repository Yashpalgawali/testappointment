package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_department")
public class Department {

	@Id
	@SequenceGenerator(name = "dept_seq" , initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "dept_seq")
	private Long dept_id;
	
	private String dept_name;
	
	@ManyToOne(cascade = {CascadeType.MERGE },targetEntity = Company.class)
	@JoinColumn(name = "comp_id",referencedColumnName = "comp_id")
	private Company company;
	
}
