package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.dataaccess.dao.admincor.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	
	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public Project getProject(Long id) {
		return projectDAO.getProject(id);
	}
	
	@Override
	public Project persist(Project project) {
		return projectDAO.persist(project);
	}

	@Override
	public Project update(Project project) {
		return projectDAO.update(project);
	}

	@Override
	public List<Project> loadProjects(Integer first, Integer pageSize, String sortField, boolean ascending, Map<String, Object> filters){
		return projectDAO.loadProjects(first,pageSize,sortField,ascending,filters);
	}
	
	@Override
	public List<Project> getProjects(Company company) {
		return projectDAO.getProjects(company);
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
