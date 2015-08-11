package com.almabani.dataaccess.dao.admincor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface CompanyDAO extends AbstractDAOInt{

	Integer getCountOfCompany(Map<String, Object> filters);

	List<Company> loadMCompanies(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	Company addCompany(Company company);

	Company getCompany(Long id);

	Company getCompany(String fedralIdentityCode);
	
	List<Company> getAllCompanies();
	
}
