package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.dataaccess.dao.adminoam.ProjectJobTitleDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ProjectJobTitleDAOImpl extends AbstractDAO implements ProjectJobTitleDAO {
	
	private static final long serialVersionUID = -7428297616495316916L;

	@Override
	public ProjectJobTitle persist(ProjectJobTitle projectJobTitle) {
		super.persist(projectJobTitle);
		return projectJobTitle;
	}

	@Override
	public ProjectJobTitle update(ProjectJobTitle projectJobTitle) {
		getCurrentSession().merge(projectJobTitle);
		return projectJobTitle;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectJobTitle> getAllProjectJobTitles() {
		return super.getAllEntities(ProjectJobTitle.class);
	}

	@Override
	public ProjectJobTitle getProjectJobTitle(Long id) {
		return (ProjectJobTitle) super.getEntity(ProjectJobTitle.class, id);
	}

	@Override
	public Integer getCountOfProjectJobTitle(Map<String, Object> filters) {
		return super.getCountOfResults(ProjectJobTitle.class, filters);
	}

	@Override
	public List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters) {
		return super.lazyLoadEntities(ProjectJobTitle.class, first, pageSize, sortField, asc, filters);
	}
	
}
