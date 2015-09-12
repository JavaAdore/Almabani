package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface QoutationDAO extends AbstractDAOInt{

	Integer getCountOfQoutations(Map<String, Object> filters);

	List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	OamQuotation addOrUpdateQuotation(OamQuotation oamQuotation);

	List<OamQuotation> getAllQuotations();

	OamQuotation getQuotataion(Long quotationID);

	List<OamQuotation> getAllQuotations(Company company);

	
	
}
