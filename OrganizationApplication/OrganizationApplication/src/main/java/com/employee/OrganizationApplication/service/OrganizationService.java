package com.employee.OrganizationApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.OrganizationApplication.db.OrganizationDb;
import com.employee.OrganizationApplication.entity.Organization;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationDb organizationDb;
	
	public Organization findById(Long id) {
		return organizationDb.findById(id).orElse(null);
	}
	
	

}
