package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface ProjectJobTitleDAO extends AbstractDAOInt{

	ProjectJobTitle persist(ProjectJobTitle projectJobTitle);
	
	ProjectJobTitle update(ProjectJobTitle projectJobTitle);
	
	List<ProjectJobTitle> getAllProjectJobTitles();

	ProjectJobTitle getProjectJobTitle(Long id);

	Integer getCountOfProjectJobTitle(Map<String, Object> filters);

	List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters);
	
}
