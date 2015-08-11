package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.dataaccess.dao.admincor.EmployeeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class EmployeeDAOImp extends AbstractDAO implements EmployeeDAO {
	
	private static final long serialVersionUID = -5730946229422189895L;

	@Override
	public void persist(Employee employee) {
		super.persist(employee);
	}

	@Override
	public void update(Employee employee) {
		getCurrentSession().merge(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		return (Employee)super.getEntity(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees(DepartmentSection departmentSection) {
		Query query = getCurrentSession().createQuery("select e from Employee e where e.departmentSection =:departmentSection");
		query.setParameter("departmentSection", departmentSection);
		return query.list();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return super.getAllEntities(Employee.class);    
	}
	
}
