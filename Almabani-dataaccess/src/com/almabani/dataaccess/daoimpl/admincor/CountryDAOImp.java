package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

  
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.dataaccess.dao.admincor.CountryDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class CountryDAOImp extends AbstractDAO implements CountryDAO {
	
	private static final long serialVersionUID = -184644810946140575L;

	@Override
	public Country getCountry(Long id) {
		return (Country) super.getEntity(Country.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountries() {
		return super.getAllEntities(Country.class);
	}

}
