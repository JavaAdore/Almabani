package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface CompanyService {

	Integer getCountOfCompany(Map<String, Object> filters);

	List<Company> loadCompanies(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	Company addCompany(Company company) throws AlmabaniException;

	Company getCompany(Long id);

	Company updateCompany(Company company) throws AlmabaniException;
	
	List<Company> getAllCompanies();


}
