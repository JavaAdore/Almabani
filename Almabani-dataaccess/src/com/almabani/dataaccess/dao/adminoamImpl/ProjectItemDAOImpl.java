package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.constant.DataAccessConfig;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.ProjectItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ProjectItemDAOImpl extends AbstractDAO implements ProjectItemDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public List<OamProjectItem> getAllProjectItems() {
		return super.getAllEntities(OamProjectItem.class);
	}

	@Override
	public OamProjectItem getProjectItem(Long projectItemId) {
		return (OamProjectItem) super.getEntity(OamProjectItem.class,
				projectItemId);
	}

	@Override
	public Integer getCountOfProjectItems(Map<String, Object> filters) {
		return super.getCountOfResults(OamProjectItem.class, filters);
	}

	@Override
	public List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamProjectItem.class, first, pageSize,
				sortField, ascending, filters);
	}

	@Override
	public OamProjectItem persist(OamProjectItem oamProjectItem) {
		return (OamProjectItem) super.persist(oamProjectItem);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(Company company) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamProjectItem x where x.project.company =:company ");
		query.setParameter("company", company);
		return query.list();
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Department department) {

		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamProjectItem x where  (upper(x.item.itemDescription) like upper(:itemNameOrDescription) or upper(x.item.itemCode) like upper(:itemNameOrDescription)) and  x.item.itemCategory.comDepartmentSection.department =:department ");
		query.setParameter("department", department);
		query.setParameter("itemNameOrDescription",
				projectItemNameOrDescription);
		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE);
		return query.list();
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(Department department) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamProjectItem x where    x.item.itemCategory.comDepartmentSection.department =:department ");
		query.setParameter("department", department);
		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE);
		return query.list();
	}

	

}
