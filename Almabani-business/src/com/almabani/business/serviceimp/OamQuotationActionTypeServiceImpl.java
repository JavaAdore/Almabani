package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.OamQuotationActionTypeService;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionTypeDAO;

@Service
public class OamQuotationActionTypeServiceImpl implements
		OamQuotationActionTypeService {

	@Autowired
	OamQuotationActionTypeDAO qamQuotationActionTypeDAO;

	@Override
	public List<OamQuotationActionType> getAvailableQuotationActionTypes(OamQuotation selected) {
			
		OamQuotationActionType currentType = 	selected.getQuotataionActions().get(selected.getQuotataionActions().size()-1).getOamTypesQuotActions();
		 List<OamQuotationActionType> availableQuotationActionTypes =	qamQuotationActionTypeDAO.getAvailableQuotationActionTypes(selected);
		 availableQuotationActionTypes.add(0, currentType);
		 return availableQuotationActionTypes;
	}

	@Override
	public OamQuotationActionType getOamQuotationActionType(Long id) {
		return qamQuotationActionTypeDAO.getOamQuotationActionType(id);
	}

}
