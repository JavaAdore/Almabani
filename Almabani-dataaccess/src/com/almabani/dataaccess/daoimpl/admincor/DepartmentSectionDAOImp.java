package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;
import com.almabani.dataaccess.dao.admincor.DepartmentSectionDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class DepartmentSectionDAOImp extends AbstractDAO implements
		DepartmentSectionDAO {

	private static final long serialVersionUID = -6221163056459255430L;

	@Override
	public void persist(DepartmentSection departmentSection) {
		super.persist(departmentSection);
	}

	@Override
	public void update(DepartmentSection departmentSection) {
		getCurrentSession().merge(departmentSection);
	}

	@Override
	public DepartmentSection getDepartmentSection(Long id) {
		return (DepartmentSection) super.getEntity(DepartmentSection.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentSection> getDepartmentSections(Department department) {
		Query query = getCurrentSession()
				.createQuery(
						"select ds from DepartmentSection ds where ds.department =:department");
		query.setParameter("department", department);
		return query.list();
	}

	@Override
	public List<VComDepartmentSection> loadDepartmentSectionsView(
			Integer first, Integer pageSize, String sortField,
			boolean assending, Map<String, Object> filters) {
		return super.lazyLoadEntities(VComDepartmentSection.class, first,
				pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getNumberOfDepartmentSectionsView(Map<String, Object> filters) {
		return super.getCountOfResults(VComDepartmentSection.class, filters);
	}

}
