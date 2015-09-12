package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.dataaccess.dao.adminoam.QoutationDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class QoutationDAOImpl extends AbstractDAO implements QoutationDAO {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public Integer getCountOfQoutations(Map<String, Object> filters) {
		return super.getCountOfResults(OamQuotation.class, filters);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamQuotation.class, first, pageSize, sortField, assending, filters);
	}  

	@Override
	public OamQuotation addOrUpdateQuotation(OamQuotation oamQuotation) {
		return (OamQuotation) super.persist(oamQuotation);
	}

	@Override
	public List<OamQuotation> getAllQuotations() {
		return super.getAllEntities(OamQuotation.class);
	}

	@Override
	public OamQuotation getQuotataion(Long quotationID) {
		return (OamQuotation) super.getEntity(OamQuotation.class , quotationID);
	}

	@Override
	public List<OamQuotation> getAllQuotations(Company company) {
		Query query = super.getCurrentSession().createQuery("select x from OamQuotation x where x.department.company=:company");
		query.setParameter("company", company);
		return query.list();
	}
     
}
