package com.almabani.dataaccess.daoimpl.admincor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.DepartmentDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class DepartmentDAOImp extends AbstractDAO implements DepartmentDAO {

	private static final long serialVersionUID = 3379125370000448399L;

	@Autowired
	private DefaultSqlSessionFactory defaultSqlSessionFactory;

	@Override
	public Department getDepartment(Long id) {
		return (Department) super.getEntity(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		return super.getAllEntities(Department.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments(Company company) {
		Query query = getCurrentSession().createQuery(
				"select d from Department d where d.company =:company");
		query.setParameter("company", company);
		return query.list();
	}

	@Override
	public List<Department> getLightDepartments(int companyId) {

		SqlSession sqlSession = null;
		try {
			sqlSession = defaultSqlSessionFactory.openSession();
			DepartmentDAO departmentDAO = sqlSession
					.getMapper(DepartmentDAO.class);
			List<Department> result = departmentDAO
					.getLightDepartments(companyId);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Department>();
		} finally {
			if (Utils.isNotNull(sqlSession)) {
				sqlSession.close();
			}
		}

	}

	@Override
	public List<Department> getAllLightDepartments() {
		SqlSession sqlSession = null;
		try {
			sqlSession = defaultSqlSessionFactory.openSession();
			DepartmentDAO departmentDAO = sqlSession
					.getMapper(DepartmentDAO.class);
			List<Department> result = departmentDAO.getAllLightDepartments();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Department>();
		} finally {
			if (Utils.isNotNull(sqlSession)) {
				sqlSession.close();
			}
		}
	}

	@Override
	public List<Department> loadDepartments(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return super.lazyLoadEntities(Department.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	public Integer getNumberOfDepartments(Map<String, Object> filters) {
		return super.getCountOfResults(Department.class, filters);
	}

	@Override
	public Department saveOrUpdate(Department department) {
		return (Department) super.persist(department);
	}

}
