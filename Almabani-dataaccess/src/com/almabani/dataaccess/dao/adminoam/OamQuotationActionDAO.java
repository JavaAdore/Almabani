package com.almabani.dataaccess.dao.adminoam;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface OamQuotationActionDAO extends AbstractDAOInt{

	OamQuotationAction addOrUpdateQuotationAction(
			OamQuotationAction oamQuotationAction);




	
	
	
}
