package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Designation;
import com.example.demo.repository.DesignationRepository;

@Service("desigserv")
public class DesignationServImpl implements DesignationService {

	@Autowired
	DesignationRepository desigrepo;
	
	@Override
	public Designation saveDesignation(Designation desig) {
		// TODO Auto-generated method stub
		return desigrepo.save(desig);
	}

	@Override
	public List<Designation> getAllDesignation() {
		// TODO Auto-generated method stub
		return desigrepo.findAll();
	}

	@Override
	public Designation getDesignationById(String id) {
		// TODO Auto-generated method stub
		Long did = Long.valueOf(id);
		
		return desigrepo.findById(did).get();
	}

}
