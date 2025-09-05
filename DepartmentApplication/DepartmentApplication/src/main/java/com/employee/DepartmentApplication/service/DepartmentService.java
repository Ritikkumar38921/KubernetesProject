package com.employee.DepartmentApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DepartmentApplication.db.DepartmentDb;
import com.employee.DepartmentApplication.entity.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDb departmentDb;
	
	public List<Department> findAll(){
		return departmentDb.findAll();
	}
	
	public Department findById(Long id) {
		return departmentDb.findById(id).orElse(null);
	}
	
	public List<Department> findByOrganizationId(Long organizationId){
		return departmentDb.findByOrganizationId(organizationId);
	}
	
	public Department save(Department department) {
		return departmentDb.save(department);
	}
	
	public Department findByIdWithEmployees(Long id) {
		Department department = departmentDb.findById(id).orElseThrow();
		
		
		
	}

}
