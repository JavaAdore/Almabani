package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;

@Service
public interface EmployeeService {
	
	Employee saveOrUpdate(Employee employee);
	
	Employee getEmployee(Long id);

	List<Employee> getEmployees(DepartmentSection selectedDepartmentSection);

	List<Employee> getAllEmployees();

}
