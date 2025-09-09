package com.employee.OrganizationApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.OrganizationApplication.DepartmentClient;
import com.employee.OrganizationApplication.db.OrganizationDb;
import com.employee.OrganizationApplication.entity.DepartmentDTO;
import com.employee.OrganizationApplication.entity.EmployeeDTO;
import com.employee.OrganizationApplication.entity.Organization;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationDb organizationDb;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	public Organization findById(Long id) {
		return organizationDb.findById(id).orElse(null);
	}
	
	public Organization findByIdAndDepartmentWithoutEmployees(Long id) {
		Organization organization = organizationDb.findById(id).orElseThrow();
		List<DepartmentDTO> departments = departmentClient.findByOrganizationId(id);
		organization.setDepartments(departments);
		return organization;
	}
	
	public Organization findByIdAndDepartmentWithEmployees(Long id) {
		Organization organization = organizationDb.findById(id).orElseThrow();
		List<DepartmentDTO> departments = departmentClient.findByOrganizationId(id);
		
		for(DepartmentDTO department : departments) {
			List<EmployeeDTO> employeess = departmentClient.findByDepartmentIdWithEmployees(department.getId());
			department.setEmployees(employeess);
		}
		
		organization.setDepartments(departments);
		return organization;
	}
	
	

}
