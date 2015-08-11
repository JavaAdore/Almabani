package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ContractorDAO extends AbstractDAOInt{

	Contractor add(Contractor contractor) throws AlmabaniException;

	Contractor update(Contractor contractor) throws AlmabaniException;
	
	Contractor getContractor(Long id);
	
	List<Contractor> getAllContractors();
	
}
