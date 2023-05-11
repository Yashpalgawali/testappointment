package com.example.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Department;

@Repository("deptrepo")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Modifying
	@Transactional
	@Query(value="UPDATE  Department d SET d.dept_name=?1,d.company=?2 WHERE d.dept_id=?3")
	public int  updateDepartment(String dname,Long cid,Long did);
	
}
