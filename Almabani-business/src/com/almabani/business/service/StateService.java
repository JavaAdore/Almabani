package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;

@Service
public interface StateService {
	List<State> getAllStates();

	List<State> getStates(Country country);

	State getState(Long countryId, String stateCode);

}
