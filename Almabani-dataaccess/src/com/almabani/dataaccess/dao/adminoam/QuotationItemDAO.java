package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface QuotationItemDAO extends AbstractDAOInt{

	Integer getCountOfQoutationItems(Map<String, Object> filters);

	List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean accending, Map<String, Object> filters);

	OamItemQuotation addOrUpdate(OamItemQuotation oamItemQuotation);

	OamItemQuotation getItemQuotation(Long itemQuotationId);

	List<OamItemQuotation> getAllQuotationItems();

	List<OamItemQuotation> getAllQuotationItems(Company company);

	List<OamItemQuotation> getItemQuotataion(OamProjectItem oamProjectItem);

	List<OamItemQuotation> getQuotationItem(OamQuotation oamQuotation);

 
	
}
