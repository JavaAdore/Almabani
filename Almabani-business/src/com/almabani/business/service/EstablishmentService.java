package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;

@Service
public interface EstablishmentService {
	
	List<Establishment> getEstablishments();

	Establishment getEstablishment(Long key);

	List<Establishment> getEstablishments(Company company);

	
}
