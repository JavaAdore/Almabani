package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.AllocationTypeService;
import com.almabani.business.service.OamQuotationDocumentService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationDocumentDAO;

@Service
public class OamQuotationDocumentServiceImpl implements
		OamQuotationDocumentService {

	@Autowired
	OamQuotationDocumentDAO oamQuotationDocumentDAO;

	@Override
	public List<OamQuotationDocument> getQuotationDocuments(
			OamQuotation quotation) {

		List<OamQuotationDocument> oamQuotationDocuments = oamQuotationDocumentDAO
				.getQuotationDocuments(quotation);
		quotation.setQuotationDocuments(oamQuotationDocuments);
		return oamQuotationDocuments;
		
	}

}
