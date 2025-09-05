package com.employee.EmployeeApplication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DepartmentApplication")
public interface DepartmentClient {
	
	@GetMapping("/api/departments/{id}")
    Department getDepartmentById(@PathVariable Long id);
	
	class Department{
		private Long id;
		private String name;
		private String code;
		private Long organizationId;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Long getOrganizationId() {
			return organizationId;
		}
		public void setOrganizationId(Long organizationId) {
			this.organizationId = organizationId;
		}
		
	}

}
