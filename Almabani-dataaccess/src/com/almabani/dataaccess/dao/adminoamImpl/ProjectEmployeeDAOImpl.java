package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.ProjectEmployeeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

/**
 * @author Mohamed_Ibrahim
 */

@Repository
public class ProjectEmployeeDAOImpl extends AbstractDAO implements ProjectEmployeeDAO {
	
	private static final long serialVersionUID = -3079238949955229595L;

	@Override
	public void persist(ProjectEmployee projectEmployee) {
		super.persist(projectEmployee);
	}

	@Override
	public void update(ProjectEmployee projectEmployee) {
		getCurrentSession().merge(projectEmployee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectEmployee> getAllProjectEmployee() {
		return super.getAllEntities(ProjectEmployee.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectEmployee> getProjectEmployee(Employee employee) {
		Query query = getCurrentSession().createQuery("select pe from ProjectEmployee pe where pe.employee=:employee");
		query.setParameter("employee", employee);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectEmployee> getProjectEmployee(List<Employee> employees) {
//		Query query = getCurrentSession().createQuery("select pe from ProjectEmployee pe where pe.employee IN (:employees)");
//		query.setParameter("employees", employees);
//		return query.list();
		if(Utils.isNotEmptyList(employees)){
		Criteria criteria = getCurrentSession().createCriteria(ProjectEmployee.class);
		Disjunction orConditions = Restrictions.disjunction();
		orConditions.add(Restrictions.in("employee", employees));
		criteria.add(orConditions);
		return criteria.list();
		}else
		{
			return new ArrayList<ProjectEmployee>();
		}
	}  
 
	@Override
	public Integer getNumberOfProjectEmployees(Map<String, Object> filters) {
		return super.getCountOfResults(ProjectEmployee.class, filters);
	}

	@Override
	public List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return super.lazyLoadEntities(ProjectEmployee.class, first, pageSize, sortField, ascending, filters); 
	}
	
}
