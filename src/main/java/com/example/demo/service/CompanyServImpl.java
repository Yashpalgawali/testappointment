package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Company;
import com.example.demo.repository.CompanyRepository;

@Service("compserv")
public class CompanyServImpl implements CompanyService {

	@Autowired
	CompanyRepository comprepo;
	
	@Override
	public Company saveCompany(Company comp) {
		// TODO Auto-generated method stub
		return comprepo.save(comp);
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return comprepo.findAll();
	}

	@Override
	public Company getCompanyByCompId(String cid) {
		// TODO Auto-generated method stub
		
		Long cmpid = Long.valueOf(cid);
		Company comp = null;
		try {
			Optional<Company> opt =comprepo.findById(cmpid); 
			comp = opt.get();
			return comp;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public int updateCompany(Company comp) {
		// TODO Auto-generated method stub
		return comprepo.updateCompany(comp.getComp_name(), comp.getComp_id());
	}

}
