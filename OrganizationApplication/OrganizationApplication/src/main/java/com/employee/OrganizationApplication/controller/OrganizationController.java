package com.employee.OrganizationApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.OrganizationApplication.entity.Organization;
import com.employee.OrganizationApplication.service.OrganizationService;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable Long id){
		return organizationService.findById(id);
	}
	
	

}
