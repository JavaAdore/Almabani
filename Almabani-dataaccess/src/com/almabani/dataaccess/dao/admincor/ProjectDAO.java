package com.almabani.dataaccess.dao.admincor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ProjectDAO extends AbstractDAOInt{

	Integer getCountOfProject(Map<String, Object> filters);

	List<Project> loadProjects(Integer first, Integer pageSize, String sortField, boolean ascending, Map<String, Object> filters);

	Project persist(Project Project);

	Project update(Project project);
	
	Project getProject(Long id);
	
	List<Project> getProjects(Company company);
	
	List<Project> getAllCompanies();
	
	boolean isProjectCodeExist(String projectCode);
	
}
