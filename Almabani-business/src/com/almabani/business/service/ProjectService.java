package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;

@Service
public interface ProjectService {
	
	Project persist(Project project);
	
	Project update(Project project);
	
	Project getProject(Long id);

	Integer getCountOfProject(Map<String, Object> filters);

	List<Project> loadProjects(Integer first, Integer pageSize, String sortField, boolean ascending, Map<String, Object> filters);
	
	List<Project> getProjects(Company company);
	
	List<Project> getAllProjects();
	
	boolean isProjectCodeExist(String projectCode);
	
}
