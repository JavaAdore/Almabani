package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
@Repository
public interface StateDAO {
	
	public List<State> getAllStates();

	public List<State> getStates(Country country);

	public State getState(Long countryId, String stateCode);

	public void test();
}
