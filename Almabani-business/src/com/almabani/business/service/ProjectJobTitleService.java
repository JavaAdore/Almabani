 package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;

@Service
public interface ProjectJobTitleService {

	ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle);
	
	List<ProjectJobTitle> getAllProjectJobTitles();

	ProjectJobTitle getProjectJobTitle(Long id);

	Integer getCountOfProjectJobTitle(Map<String, Object> filters);

	List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters);
	
}
