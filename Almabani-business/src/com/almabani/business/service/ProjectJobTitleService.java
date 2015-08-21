 package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;

@Service
public interface ProjectJobTitleService {

	ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle);
	
	ProjectJobTitle getProjectJobTitle(Long id);
	
	List<ProjectJobTitle> getProjectJobTitles(Company company);
	
	List<ProjectJobTitle> getAllProjectJobTitles();

	Integer getCountOfProjectJobTitle(Map<String, Object> filters);

	List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters);

	
}
