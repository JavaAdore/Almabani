package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.dataaccess.dao.adminoam.ItemCategoryDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ItemCategoryDAOImpl extends AbstractDAO implements ItemCategoryDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OamItemCategory> loadItemCategories(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(OamItemCategory.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public OamItemCategory addItemCategory(OamItemCategory itemCategory) {
		return (OamItemCategory) super.persist(itemCategory);
	}

	@Override
	public OamItemCategory getItemCategory(Long id) {
		return (OamItemCategory) super.getEntity(OamItemCategory.class, id);
	}

	

	@Override
	public Integer getCountOfItemCategories(Map<String, Object> filters) {

		return super.getCountOfResults(OamItemCategory.class, filters);
	}

	@Override
	public List<OamItemCategory> getAllItemCategories() {
		return (List<OamItemCategory>)super.getAllEntities(OamItemCategory.class);
	}

	@Override
	public List<OamItemCategory> getAllItemCategories(Department department) {
	
		Query query = super.getCurrentSession().createQuery("select x from OamItemCategory x where x.comDepartmentSection.department =:department");
		query.setParameter("department", department);
		return query.list(); 
	}

}
