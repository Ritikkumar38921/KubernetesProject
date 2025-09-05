package com.employee.DepartmentApplication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OrganizationApplication")
public class OrganizationClient {
	
//	@GetMapping("")
	Organization getOrganizationById( Long organizationId );
	
    class Organization {
        private Long id;
        private String name;
        private String address;
        private String code;
        
        // Getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
    }

}
