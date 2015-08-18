package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.dataaccess.dao.admincor.ProjectDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ProjectDAOImpl extends AbstractDAO implements ProjectDAO {
	
	private static final long serialVersionUID = 2976343398361942765L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> loadProjects(Integer first, Integer pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {

		return super.lazyLoadEntities(Project.class, first, pageSize,
				sortField, ascending, filters);
	}

	@Override
	@Transactional
	public Project persist(Project Project) {
		return (Project) super.persist(Project);
	}
	
	@Override
	public Project update(Project project) {
		return (Project) getCurrentSession().merge(project);
	}

	@Override
	public Project getProject(Long id) {
		return (Project) super.getEntity(Project.class, id);
	}

	@Override
	public Integer getCountOfProject(Map<String, Object> filters) {

		return super.getCountOfResults(Project.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllCompanies() {
		return super.getAllEntities(Project.class);
	}

	@Override
	public boolean isProjectCodeExist(String projectCode) {
		Query query = getCurrentSession().createQuery("select p from Project p where p.projectCode =:projectCode");
		query.setParameter("projectCode", projectCode);
		return query.list().size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(Company company) {
		
		Query query = getCurrentSession().createQuery("select p from Project p where p.company =:company");
		query.setParameter("company", company);
		return query.list();
	}

}
