package com.almabani.dataaccess.dao.adminoam;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface OamDocumentTypeDAO extends AbstractDAOInt{

	List<OamDocumentType> getDocuemtTypeList(Company currentLoggedUserCompany);

	OamDocumentType getDocumentType(Long id);

	
}
