package com.almabani.dataaccess.dao.adminoam;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface OamQuotationActionTypeDAO extends AbstractDAOInt{

	
	
	List<OamQuotationActionType> getAllQuotationActionType(Company company);

	List<OamQuotationActionType> getAvailableQuotationActionTypes(
			OamQuotation selected);

	OamQuotationActionType getOamQuotationActionType(Long id);

	OamQuotationActionType getApproveActionType(Company company);
	
	
}
