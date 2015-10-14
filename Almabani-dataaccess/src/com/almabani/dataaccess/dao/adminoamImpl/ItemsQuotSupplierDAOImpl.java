package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.util.Utils;
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

	@Override
	public OamItemsQuotSupplier getSelectedSupplier(
			OamItemQuotation oamItemQuotation) {
		Query query = super.getCurrentSession().createQuery("select x from OamItemsQuotSupplier  x  where x.itemQuotation =:itemQuotation and upper(x.indSelected) like upper(:selected) ");
		query.setParameter("itemQuotation", oamItemQuotation);
		query.setParameter("selected" ,  DataAccessConstants.YES);
		return (OamItemsQuotSupplier) Utils.getFirstResult(query.list());	
	}

	@Override
	public void unselectOldSupplierOfQuotationItem(
			OamItemQuotation itemQuotation) {
		Query query = super.getCurrentSession().createQuery("update OamItemsQuotSupplier x set x.indSelected =:notSelected and x.selectionDate = :selectionDate and x.selectionUserName =:selectionUserName");
		query.setParameter("notSelected", DataAccessConstants.NO);
		query.setParameter("selectionDate", null); 
		query.setParameter("selectionUserName", null); 
		query.executeUpdate(); 
	}
	
	
	
	


}
