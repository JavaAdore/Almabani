package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;

@Service
public interface DepartmentService {
	
	Department saveOrUpdate(Department department);
	
	Department getDepartment(Long id);

	List<Department> getDepartments();

	List<Department> getDepartments(Company company);

	List<Department> getLightDepartments(Company company);

	List<Department> getLightDepartments();

}
