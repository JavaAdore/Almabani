package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.QoutationService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.dataaccess.dao.adminoam.QoutationDAO;

@Service
public class QoutationServiceImpl implements QoutationService {

	@Autowired
	QoutationDAO qoutationDAO;
	@Override
	public Integer getCountOfQoutations(Map<String, Object> filters) {
 		return qoutationDAO.getCountOfQoutations( filters);

	}
	@Override
	public List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return qoutationDAO.loadQoutations( first,  pageSize,
				 sortField,  assending, filters);
	}
	@Override
	public OamQuotation updateQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setModificationLoginCode(commonDriverMap.getCurrentUserCode());
		
		return qoutationDAO.addOrUpdateQuotation(oamQuotation);

		
		
	}
	@Override
	public OamQuotation addQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamQuotation.setCreationDate(date);
		oamQuotation.setInsertRowDate(date); 
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setInsertLoginCode(commonDriverMap.getCurrentUserCode());
		oamQuotation.setModificationLoginCode(commonDriverMap.getCurrentUserCode());
		return qoutationDAO.addOrUpdateQuotation(oamQuotation);
	}
	@Override
	public List<OamQuotation> getAllQuotations() {
		return qoutationDAO.getAllQuotations();
	}
	@Override
	public OamQuotation getQuotataion(Long quotationID) {
		return qoutationDAO.getQuotataion( quotationID);
	}
	

}
