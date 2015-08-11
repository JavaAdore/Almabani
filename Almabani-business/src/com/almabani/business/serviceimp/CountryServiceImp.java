package com.almabani.business.serviceimp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.CountryService;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.dataaccess.dao.admincor.CountryDAO;
@Service
 
public class CountryServiceImp implements CountryService{

	
	@Autowired
	private CountryDAO countryDAO;
	
	@Override
	public Country getCountry(Long id) {
		return countryDAO.getCountry(id);
	}
	
	@Override
	public List<Country> getAllCountries() {
		return countryDAO.getAllCountries();
	}
	
}
