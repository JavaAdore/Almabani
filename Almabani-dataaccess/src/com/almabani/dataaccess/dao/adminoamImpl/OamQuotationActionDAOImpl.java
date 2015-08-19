package com.almabani.dataaccess.dao.adminoamImpl;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class OamQuotationActionDAOImpl extends AbstractDAO implements OamQuotationActionDAO {
	
	private static final long serialVersionUID = -1639272880814635175L;

	@Override
	public OamQuotationAction addOrUpdateQuotationAction(
			OamQuotationAction oamQuotationAction) {
		return (OamQuotationAction) super.persist(oamQuotationAction);
	}

	
	
	
}
