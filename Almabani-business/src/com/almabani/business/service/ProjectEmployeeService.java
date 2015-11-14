package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ProjectEmployeeService {

	List<ProjectEmployee> getProjectEmployee(Employee employee);
	
	List<ProjectEmployee> getProjectEmployee(List<Employee> employees);

	ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee) throws AlmabaniException;

	Integer getNumberOfProjectEmployees(Map<String, Object> filters);

	List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);
	
}
