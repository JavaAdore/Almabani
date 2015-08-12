package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Project;

@Service
public interface ProjectService {

	Integer getCountOfProject(Map<String, Object> filters);

	List<Project> loadProjects(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	Project saveOrUpdate(Project project);
	
	Project getProject(Long id);
	
	List<Project> getAllProjects();
	
	boolean isProjectCodeExist(String projectCode);
	
}
