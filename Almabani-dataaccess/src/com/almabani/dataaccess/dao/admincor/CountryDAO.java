package com.almabani.dataaccess.dao.admincor;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
 
public interface CountryDAO extends AbstractDAOInt {

	Country getCountry(Long id);
	
	List<Country> getAllCountries();
	
}
