package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Designation;

public interface DesignationService {
	
	public Designation saveDesignation(Designation desig);
	
	public List<Designation> getAllDesignation();
	
	public Designation getDesignationById(String id);
	

}