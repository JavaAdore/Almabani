package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.dataaccess.dao.AbstractDAOInt;

/**
 * @author Mohamed_Ibrahim
 */

@Repository
public interface ProjectEmployeeDAO extends AbstractDAOInt{
	
	ProjectEmployee persist(ProjectEmployee projectEmployee);
	
	ProjectEmployee update(ProjectEmployee projectEmployee);
	
	List<ProjectEmployee> getAllProjectEmployee();
	
	List<ProjectEmployee> getProjectEmployee(Employee employee);
	
	List<ProjectEmployee> getProjectEmployee(List<Employee> employees);

	Integer getNumberOfProjectEmployees(Map<String, Object> filters);

	List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);
	
}
