package com.employee.DepartmentApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DepartmentApplication.entity.Department;
import com.employee.DepartmentApplication.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }
    
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }
    
    @GetMapping("/organization/{organizationId}")
    public List<Department> getDepartmentsByOrganization(@PathVariable Long organizationId) {
        return departmentService.findByOrganizationId(organizationId);
    }
    
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }
    
    @GetMapping("/{id}/with-employees")
    public Department findByIdWithEmployees(@PathVariable Long id) {
    	return departmentService.findByIdWithEmployees(id);
    }
    
}