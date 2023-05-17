package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Department;
import com.example.demo.repository.DepartmentRepository;

@Service("deptserv")
public class DepartmentServImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptrepo;
	
	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return deptrepo.save(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptrepo.findAll();
	}

	@Override
	public Department getDepartmentById(String id) {
		// TODO Auto-generated method stub
		Long did = Long.valueOf(id);
		return deptrepo.findById(did).get();
	}

	@Override
	public int updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return deptrepo.updateDepartment(dept.getDept_name(), dept.getCompany().getComp_id(), dept.getDept_id());
	}

	@Override
	public List<Department> getDepartmentByCompId(String compid) {
		// TODO Auto-generated method stub
		
		Long cid = Long.valueOf(compid);
		return deptrepo.getDepartmentbyCompId(cid);
	}

}
