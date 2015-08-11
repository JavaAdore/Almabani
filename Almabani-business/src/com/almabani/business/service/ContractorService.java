package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ContractorService {
	
	Contractor addContractor(Contractor contractor) throws AlmabaniException;

	Contractor updateContractor(Contractor contractor) throws AlmabaniException;
	
	Contractor getContractor(Long id);
	
	List<Contractor> getAllContractors();


}
