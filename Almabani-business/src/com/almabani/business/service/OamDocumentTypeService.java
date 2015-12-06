 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;

@Service
public interface OamDocumentTypeService {

	List<OamDocumentType> getDocuemtTypeList(Company currentLoggedUserCompany);

	OamDocumentType getDocumentType(Long id);

	
	

}
