package com.employee.OrganizationApplication.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.OrganizationApplication.entity.Organization;

@Repository
public interface OrganizationDb extends JpaRepository<Organization, Long> {

	
}
