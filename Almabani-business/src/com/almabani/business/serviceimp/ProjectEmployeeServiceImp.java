package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectEmployeeService;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.dataaccess.dao.adminoam.ProjectEmployeeDAO;

@Service
public class ProjectEmployeeServiceImp implements ProjectEmployeeService {
	
	@Autowired
	ProjectEmployeeDAO projectEmployeeDAO;

	@Override
	public List<ProjectEmployee> getProjectEmployee(Employee employee) {
		return projectEmployeeDAO.getProjectEmployee(employee);
	}
	
	@Override
	public List<ProjectEmployee> getProjectEmployee(List<Employee> employees) {
		return projectEmployeeDAO.getProjectEmployee(employees);
	}

	@Override
	public ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee) {
		if(projectEmployee.getId() == null){
			projectEmployeeDAO.persist(projectEmployee);
		} else{
			projectEmployeeDAO.update(projectEmployee);
		}
		return projectEmployee;
	}

	@Override
	public Integer getNumberOfProjectEmployees(Map<String, Object> filters) {
		return projectEmployeeDAO.getNumberOfProjectEmployees( filters);
	}

	@Override
	public List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return projectEmployeeDAO.loadProjectsAllocationEmployee( first,
				 pageSize,  sortField,  ascending,
				 filters) ;
	}
	
}
