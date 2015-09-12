package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.QuotationItemService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.dataaccess.dao.adminoam.QuotationItemDAO;

@Service
public class QuotationItemsServiceImpl implements QuotationItemService {

	@Autowired
	QuotationItemDAO qoutationItemDAO;

	@Override
	public Integer getCountOfQoutationItems(Map<String, Object> filters) {
		return qoutationItemDAO.getCountOfQoutationItems( filters);
	}

	@Override
	public List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean accending, Map<String, Object> filters) {
		return qoutationItemDAO.loadItemQuotataions( first,  pageSize,
				 sortField,  accending, filters);
	}

	@Override
	public OamItemQuotation updateQuotationItem(
			OamItemQuotation oamItemQuotation, CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamItemQuotation.setLastModificationDate(date);
		oamItemQuotation.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return  qoutationItemDAO.addOrUpdate(oamItemQuotation);
	}

	@Override
	public OamItemQuotation addQuotationItem(OamItemQuotation oamItemQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamItemQuotation.setLastModificationDate(date);
		oamItemQuotation.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return  qoutationItemDAO.addOrUpdate(oamItemQuotation);
	}

	@Override
	public OamItemQuotation getItemQuotation(Long itemQuotationId) {
		return qoutationItemDAO.getItemQuotation( itemQuotationId);
	}

	@Override
	public List<OamItemQuotation> getAllQuotationItems() {
		return qoutationItemDAO.getAllQuotationItems() ;
	}

	@Override
	public List<OamItemQuotation> getAllQuotationItems(Company company) {
		return qoutationItemDAO.getAllQuotationItems( company);
	}

	

	
}
