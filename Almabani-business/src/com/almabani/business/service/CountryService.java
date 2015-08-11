package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Country;

@Service
public interface CountryService {

	Country getCountry(Long id);
	
	List<Country> getAllCountries();

}
