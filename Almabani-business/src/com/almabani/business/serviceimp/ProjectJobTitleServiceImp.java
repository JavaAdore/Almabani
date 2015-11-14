package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectJobTitleService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.dataaccess.dao.adminoam.ProjectJobTitleDAO;

@Service
public class ProjectJobTitleServiceImp implements ProjectJobTitleService {

	@Autowired
	ProjectJobTitleDAO projectJobTitleDAO;
	
	@Override
	public ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle) {
		if(projectJobTitle.getId()==null)
			projectJobTitleDAO.persist(projectJobTitle);
		else{
			projectJobTitleDAO.update(projectJobTitle);
		}
		return projectJobTitle;
	}
	
	@Override
	public ProjectJobTitle getProjectJobTitle(Long id) {
		return projectJobTitleDAO.getProjectJobTitle(id);
	}
	
	@Override
	public List<ProjectJobTitle> getProjectJobTitles(Company company) {
		return projectJobTitleDAO.getProjectJobTitles(company);
	}
	
	@Override
	public List<ProjectJobTitle> getAllProjectJobTitles() {
		return projectJobTitleDAO.getAllProjectJobTitles();
	}

	@Override
	public Integer getCountOfProjectJobTitle(Map<String, Object> filters) {
		return projectJobTitleDAO.getCountOfProjectJobTitle(filters);
	}

	@Override
	public List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters) {
		return projectJobTitleDAO.loadProjectJobTitles( first,  pageSize,
				 sortField,  asc, filters);
	}

	@Override
	public List<ProjectJobTitle> getProjectJobTitles(Project selectedProject) {
		return projectJobTitleDAO.getProjectJobTitles( selectedProject);
	}	
	
}
