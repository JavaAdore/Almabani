package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationDocumentDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class OamQuotationDocumentDAOImpl extends AbstractDAO implements OamQuotationDocumentDAO {

	@Override
	public OamQuotationDocument addOrUpdateQuotationDocument(
			OamQuotationDocument quotationDocument) {
		
		return (OamQuotationDocument)super.persist(quotationDocument);
	}

	@Override
	public List<OamQuotationDocument> getQuotationDocuments(
			OamQuotation quotation) {
		Query query = super.getCurrentSession().createQuery("select x from OamQuotationDocument  x where x.quotation =:quotation");
		query.setParameter("quotation", quotation);
		return query.list();
	}  

	@Override
	public void deleteQuotationRelatedDocuments(OamQuotation quotation) {
		Query query = super.getCurrentSession().createQuery("delete from  OamQuotationDocument where quotation =:quotation");
		query.setParameter("quotation", quotation);
		query.executeUpdate();
	}

	@Override
	public void deleteQuotationRelatedDocumentsExcept(
			OamQuotation oamQuotation,
			List<OamQuotationDocument> oamQoutationDocuments) {
		Query query = super.getCurrentSession().createQuery("delete from  OamQuotationDocument x where  x.quotation =:quotation and x not in :oamQoutationDocuments ");
		query.setParameter("quotation", oamQuotation); 
		query.setParameterList("oamQoutationDocuments", oamQoutationDocuments);  
		query.executeUpdate();
		
	}
	
	
	
	
}
