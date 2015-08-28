package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;

@Service
public interface EmployeeService {
	
	Employee saveOrUpdate(Employee employee);
	
	Employee getEmployee(Long id);

	List<Employee> getEmployees(DepartmentSection selectedDepartmentSection);

	List<Employee> getAllEmployees();

	boolean isFederalIdentityCodeExist(String federalIdentityCode);

	Integer getNumberOfEmployees(Map<String, Object> filters);

	List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	List<Employee> getCompanyEmployees(Company company);

}
