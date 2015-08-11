package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public OamItemCategory addItemCategory(OamItemCategory company) {
		return (OamItemCategory) super.persist(company);
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

}
