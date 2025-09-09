package com.employee.DepartmentApplication.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.DepartmentApplication.entity.EmployeeDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "EmployeeApplication")
public interface EmployeeClient {

	@GetMapping("/api/employees/department/{departmentId}")
	@RateLimiter(name = "DepartmentEmployeeClient", fallbackMethod = "DepartmentEmployeeClientfb")
	@CircuitBreaker(name = "DepartmentEmployeeClient", fallbackMethod = "DepartmentEmployeeClientfb")
	@Retry(name = "DepartmentEmployeeClient", fallbackMethod = "DepartmentEmployeeClientfb")
	List<EmployeeDTO> findEmployeesByDepartmentId(@PathVariable Long departmentId);

	default List<EmployeeDTO> DepartmentEmployeeClientfb(Exception e) {
		e.printStackTrace();
		return null;
	}

}
