package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.dataaccess.dao.adminoam.ItemsQuotSupplierDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ItemsQuotSupplierDAOImpl extends AbstractDAO implements ItemsQuotSupplierDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return super.lazyLoadEntities(OamItemsQuotSupplier.class, first, pageSize, sortField, ascending, filters);
	}

	@Override
	public Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters) {
		return super.getCountOfResults(OamItemsQuotSupplier.class, filters); 
	}

	@Override
	public OamItemsQuotSupplier addOrUpdate(
			OamItemsQuotSupplier oamItemsQuotSupplier) {
		return (OamItemsQuotSupplier) super.persist(oamItemsQuotSupplier);
	}
	
	
	
	


}
