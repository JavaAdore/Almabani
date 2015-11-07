package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;

@Service
public interface DepartmentService {
	
	Department getDepartment(Long id);

	List<Department> getDepartments();

	List<Department> getDepartments(Company company);

	List<Department> getLightDepartments(Company company);

	List<Department> getLightDepartments();

	List<Department> loadDepartments(int first, int pageSize, String sortField,
			boolean assending, Map<String, Object> filters);

	Integer getNumberOfDepartments(Map<String, Object> filters);

	Department addDepartment(Department department, CommonDriverMap commonDriverMap);

	Department updateDepartment(Department department, CommonDriverMap commonDriverMap);

}
