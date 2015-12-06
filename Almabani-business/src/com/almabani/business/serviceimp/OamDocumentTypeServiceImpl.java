package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.AllocationTypeService;
import com.almabani.business.service.OamDocumentTypeService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamDocumentTypeDAO;

@Service
public class OamDocumentTypeServiceImpl implements OamDocumentTypeService {

	@Autowired
	OamDocumentTypeDAO oamDocumetTypeDAO;

	@Override
	public List<OamDocumentType> getDocuemtTypeList(
			Company currentLoggedUserCompany) {
		return oamDocumetTypeDAO.getDocuemtTypeList(currentLoggedUserCompany);
	}

	@Override
	public OamDocumentType getDocumentType(Long id) {
		return oamDocumetTypeDAO.getDocumentType(id);
	}

}
