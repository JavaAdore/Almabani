package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class OamQuotationActionTypeDAOImpl extends AbstractDAO implements OamQuotationActionTypeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	@Override
	public List<OamQuotationActionType> getAllQuotationActionType() {
		
		Query query  = getCurrentSession().createQuery("select x from OamQuotationActionType x order by  x.id");
		return (List<OamQuotationActionType>)query.list(); 
	}

	@Override
	public List<OamQuotationActionType> getAvailableQuotationActionTypes(
			OamQuotation selected) {
		
		Query query  = getCurrentSession().createQuery("select n.oamNextQuotActionId.oamTypeQuotActionNextFirst from  OamNextQuotAction n where n.oamNextQuotActionId.oamTypeQuotAction =:lastQuotationType ");
		OamQuotationActionType lastActionType = selected.getQuotataionActions().get(selected.getQuotataionActions().size()-1).getOamTypesQuotActions();
		query.setParameter("lastQuotationType", lastActionType);
		return query.list();
	}

	@Override 
	public OamQuotationActionType getOamQuotationActionType(Long id) {
		return (OamQuotationActionType) super.getEntity(OamQuotationActionType.class, id);
	}
	
		
}  
