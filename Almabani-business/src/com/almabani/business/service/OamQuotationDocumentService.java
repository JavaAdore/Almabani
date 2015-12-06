 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;

@Service
public interface OamQuotationDocumentService {

	List<OamQuotationDocument> getQuotationDocuments(OamQuotation quotation);


	

}
