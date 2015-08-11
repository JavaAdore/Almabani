package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface EstablishmentDAO extends AbstractDAOInt {

	Establishment getEstablishment(Long key);
	
	List<Establishment> getEstablishments();
	
}
