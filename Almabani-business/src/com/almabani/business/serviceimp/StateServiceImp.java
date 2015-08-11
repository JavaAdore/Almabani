package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.StateService;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.dataaccess.dao.admincor.StateDAO;
@Service
public class StateServiceImp implements StateService{
	
	@Autowired
	private StateDAO stateDAO;
	
	public List<State> getAllStates()
	{
		return stateDAO.getAllStates();
	}

	@Override
	public List<State> getStates(Country country) {

		return stateDAO.getStates( country);
	}

	@Override
	public State getState(Long countryId, String stateCode) {
		
		return stateDAO.getState(countryId, stateCode);
	}

	

}
