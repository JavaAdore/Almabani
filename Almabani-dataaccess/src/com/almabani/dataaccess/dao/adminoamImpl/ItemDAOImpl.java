package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.dataaccess.dao.adminoam.ItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ItemDAOImpl extends AbstractDAO implements ItemDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<OamItem> loadItems(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return super.lazyLoadEntities(OamItem.class, first, pageSize, sortField, ascending, filters);
	}

	@Override
	public Integer getCountOfItems(Map<String, Object> filters) {
		return super.getCountOfResults(OamItem.class, filters); 
	}

	@Override
	public OamItem addOrUpdate(
			OamItem item) {
		return (OamItem) super.persist(item);
	}

	@Override
	public List<OamItem> getAllItems() {
		
		return super.getAllEntities(OamItem.class);
	}

	@Override
	public OamItem getItem(Long itemID) {
		
		return (OamItem) super.getEntity(OamItem.class, itemID);
	}
	
	
	
	


}
