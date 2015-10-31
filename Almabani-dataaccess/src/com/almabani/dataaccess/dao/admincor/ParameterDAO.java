package com.almabani.dataaccess.dao.admincor;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.CompanyParameter;
import com.almabani.common.entity.schema.admincor.GenericParameter;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ParameterDAO extends AbstractDAOInt{

	CompanyParameter getCompanyParameter(GenericParameter operator,
			Company company);

	
	
	
}
