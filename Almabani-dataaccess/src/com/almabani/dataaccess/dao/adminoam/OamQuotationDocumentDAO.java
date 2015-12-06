package com.almabani.dataaccess.dao.adminoam;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface OamQuotationDocumentDAO extends AbstractDAOInt{

	OamQuotationDocument addOrUpdateQuotationDocument(OamQuotationDocument quotationDocument);

	List<OamQuotationDocument> getQuotationDocuments(OamQuotation quotation);

	void deleteQuotationRelatedDocuments(OamQuotation oamQuotation);

	void deleteQuotationRelatedDocumentsExcept(OamQuotation oamQuotation,
			List<OamQuotationDocument> oamQoutationDocuments);


	
}
