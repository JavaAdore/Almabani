package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.dataaccess.dao.adminoam.QuotationItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class QuotationItemDAOImpl extends AbstractDAO implements QuotationItemDAO {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getCountOfQoutationItems(Map<String, Object> filters) {
		return super.getCountOfResults(OamItemQuotation.class, filters);
	}

	@Override
	public List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamItemQuotation.class, first, pageSize, sortField, ascending, filters);
	}

	@Override
	public OamItemQuotation addOrUpdate(OamItemQuotation oamItemQuotation) {

		return (OamItemQuotation) super.persist(oamItemQuotation);
	}

	@Override
	public OamItemQuotation getItemQuotation(Long itemQuotationId) {
		return (OamItemQuotation) super.getEntity(OamItemQuotation.class, itemQuotationId);
	}

	@Override
	public List<OamItemQuotation> getAllQuotationItems() {
		return super.getAllEntities(OamItemQuotation.class);
	}
	
	
	

}
