package com.employee.OrganizationApplication.client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.OrganizationApplication.dto.DepartmentDTO;
import com.employee.OrganizationApplication.dto.EmployeeDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "DepartmentApplication" ,url = "http://localhost:8082/")
public interface DepartmentClient {
	
	@GetMapping("/api/departments/organization/{organizationId}")
	@RateLimiter(name = "OrgaizationDepartmentsClient" , fallbackMethod = "orgaizationDepartmentClientfb")
	@CircuitBreaker(name = "OrgaizationDepartmentsClient" , fallbackMethod = "orgaizationDepartmentClientfb")
	@Retry(name = "OrgaizationDepartmentsClient" , fallbackMethod = "orgaizationDepartmentClientfb")
	List<DepartmentDTO> findByOrganizationId(@PathVariable Long organizationId);
	
	@GetMapping("/api/departments/{id}/with-employees")
	@RateLimiter(name = "OrganizationDepartmentWithEmployeeClient" , fallbackMethod = "organizationDepartmentWithEmployeeClientfb")
	@CircuitBreaker(name = "OrganizationDepartmentWithEmployeeClient" , fallbackMethod = "organizationDepartmentWithEmployeeClientfb")
	@Retry(name = "OrganizationDepartmentWithEmployeeClient" , fallbackMethod = "organizationDepartmentWithEmployeeClientfb")
	List<EmployeeDTO> findByDepartmentIdWithEmployees(@PathVariable Long id);
	
	
	default List<DepartmentDTO> orgaizationDepartmentClientfb(Exception e){
		e.printStackTrace();
		return null;
	}
	
	default List<EmployeeDTO> organizationDepartmentWithEmployeeClientfb(Exception e){
		e.printStackTrace();
		return null;
	}
	
	

}
