package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectService;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.dataaccess.dao.admincor.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	
	@Autowired
	private ProjectDAO projectDAO;


	@Override
	public List<Project> loadProjects(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return projectDAO.loadProjects(first,pageSize,sortField,assending,filters);
	}

	@Override
	public Project getProject(Long id) {
		return projectDAO.getProject(id);
	}

	@Override
	public Project saveOrUpdate(Project project) {
		if(project.getId() == null)
			projectDAO.addProject(project);
		else
			projectDAO.update(project);
		
		return project;
	}

	@Override
	public Integer getCountOfProject(Map<String, Object> filters) {
		return projectDAO.getCountOfProject( filters);
	}
 
	@Override
	public List<Project> getAllProjects() {
		return projectDAO.getAllCompanies();
	}

	@Override
	public boolean isProjectCodeExist(String projectCode) {
		return projectDAO.isProjectCodeExist(projectCode);
	}	

}
