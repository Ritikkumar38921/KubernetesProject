package com.employee.EmployeeApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeApplication.db.EmployeeRepository;
import com.employee.EmployeeApplication.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired

	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    public List<Employee> findByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
    
    public List<Employee> findByOrganizationId(Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }
    
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    

}
