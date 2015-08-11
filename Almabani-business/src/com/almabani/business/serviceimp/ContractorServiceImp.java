package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ContractorService;
import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.admincor.ContractorDAO;

@Service
public class ContractorServiceImp implements ContractorService {

	@Autowired
	ContractorDAO contractorDAO;
	
	@Override
	public Contractor addContractor(Contractor contractor)
			throws AlmabaniException {
		return contractorDAO.add(contractor);
	}

	@Override
	public Contractor updateContractor(Contractor contractor)
			throws AlmabaniException {
		return contractorDAO.update(contractor);
	}

	@Override
	public Contractor getContractor(Long id) {
		return contractorDAO.getContractor(id);
	}

	@Override
	public List<Contractor> getAllContractors() {
		return contractorDAO.getAllContractors();
	}

}
