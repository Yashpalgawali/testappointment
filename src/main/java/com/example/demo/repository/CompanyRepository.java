package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Company;

@Repository("comprepo")
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE Company c SET c.comp_name=?1 WHERE c.comp_id=?2")
	public int updateCompany(String cname,Long cid);
	
}
