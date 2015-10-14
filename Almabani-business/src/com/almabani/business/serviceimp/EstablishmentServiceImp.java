package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.EstablishmentService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.dataaccess.dao.admincor.EstablishmentDAO;

@Service
public class EstablishmentServiceImp implements EstablishmentService {
	
	
	@Autowired
	private EstablishmentDAO establishmentDAO;

	@Override
	public List<Establishment> getEstablishments() {
		return establishmentDAO.getEstablishments();
	}

	@Override
	public Establishment getEstablishment(Long key) {
		return establishmentDAO.getEstablishment(key);
	}

	@Override
	public List<Establishment> getEstablishments(Company company) {
		return establishmentDAO.getEstablishments(company);
	}

	

}
