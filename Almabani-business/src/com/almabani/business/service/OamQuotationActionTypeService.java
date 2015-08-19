 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;

@Service
public interface OamQuotationActionTypeService {

	List<OamQuotationActionType> getAvailableQuotationActionTypes(
			OamQuotation selected);

	OamQuotationActionType getOamQuotationActionType(Long id);

	

}
