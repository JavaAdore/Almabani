package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.QoutationService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionTypeDAO;
import com.almabani.dataaccess.dao.adminoam.QoutationDAO;

@Service
public class QoutationServiceImpl implements QoutationService {

	@Autowired
	QoutationDAO qoutationDAO;

	@Autowired
	OamQuotationActionTypeDAO oamQuotationActionType;

	@Autowired
	OamQuotationActionDAO oamQuotationActionDAO;

	@Override
	public Integer getCountOfQoutations(Map<String, Object> filters) {
		return qoutationDAO.getCountOfQoutations(filters);

	}

	@Override
	public List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return qoutationDAO.loadQoutations(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public OamQuotation updateQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());
		if(Utils.isNull(oamQuotation)&&Utils.isNotEmptyList(oamQuotation.getQuotataionActions()))
		{ 
			oamQuotation.setSelectedActionType(oamQuotation.getQuotataionActions().get(oamQuotation.getQuotataionActions().size()-1).getOamTypesQuotActions());
		} 
		if (Utils.isNotNull(oamQuotation.getSelectedActionType())
				&& Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
			if (oamQuotation.getSelectedActionType().equals(
					oamQuotation.getQuotataionActions().get(
							oamQuotation.getQuotataionActions().size() - 1))==false) {
				if (Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
					OamQuotationAction oamQuotationAction = new OamQuotationAction();
					oamQuotationAction.setInsertActionDate(date);
					oamQuotationAction.setLastModificationDate(date);
					oamQuotationAction.setLoginActionCode(commonDriverMap
							.getCurrentUserCode());
					oamQuotationAction.setModificationLoginCode(commonDriverMap
							.getCurrentUserCode());
					oamQuotationAction.setOamQuotation(oamQuotation);
					oamQuotationAction.setOamTypesQuotActions(oamQuotation
							.getSelectedActionType());
				
					oamQuotation.getQuotataionActions().add(oamQuotationAction);
					oamQuotationAction = oamQuotationActionDAO
							.addOrUpdateQuotationAction(oamQuotationAction);   
				}  
			}
		}

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
		oamQuotation.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());

		oamQuotation = qoutationDAO.addOrUpdateQuotation(oamQuotation);
		OamQuotationAction oamQuotationAction = new OamQuotationAction();
		oamQuotationAction.setInsertActionDate(date);
		oamQuotationAction.setLastModificationDate(date);
		oamQuotationAction.setLoginActionCode(commonDriverMap
				.getCurrentUserCode());
		oamQuotationAction.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());
		oamQuotationAction.setOamQuotation(oamQuotation);
		List<OamQuotationActionType> oamQuotationActionTypes = oamQuotationActionType
				.getAllQuotationActionType();

		if (Utils.isNotEmptyList(oamQuotationActionTypes)) {
			oamQuotationAction.setOamTypesQuotActions(oamQuotationActionTypes
					.get(0));
		}

		oamQuotationAction = oamQuotationActionDAO
				.addOrUpdateQuotationAction(oamQuotationAction);
		oamQuotation.getQuotataionActions().add(oamQuotationAction);

		return oamQuotation;
	}

	@Override
	public List<OamQuotation> getAllQuotations() {
		return qoutationDAO.getAllQuotations();
	}

	@Override
	public OamQuotation getQuotataion(Long quotationID) {
		return qoutationDAO.getQuotataion(quotationID);
	}

}
