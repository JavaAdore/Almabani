package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.dataaccess.dao.admincor.DepartmentDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class DepartmentDAOImp extends AbstractDAO implements DepartmentDAO {
	
	private static final long serialVersionUID = 3379125370000448399L;

	@Override
	public void persist(Department department) {
		super.persist(department);
	}

	@Override
	public void update(Department department) {
		getCurrentSession().merge(department);
	}
	
	@Override
	public Department getDepartment(Long id) {
		return (Department)super.getEntity(Department.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		return super.getAllEntities(Department.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments(Company company) {
		Query query = getCurrentSession().createQuery("select d from Department d where d.company =:company");
		query.setParameter("company", company);
		return query.list();
	}
	
}
