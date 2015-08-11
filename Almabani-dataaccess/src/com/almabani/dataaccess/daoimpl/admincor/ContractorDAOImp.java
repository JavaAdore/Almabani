package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.admincor.ContractorDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ContractorDAOImp extends AbstractDAO implements ContractorDAO {
	
	private static final long serialVersionUID = 6933837685847118724L;

	@Override
	public Contractor add(Contractor contractor)
			throws AlmabaniException {
		super.persist(contractor);
		return contractor;
	}

	@Override
	public Contractor update(Contractor contractor)
			throws AlmabaniException {
		return (Contractor) getCurrentSession().merge(contractor);
	}

	@Override
	public Contractor getContractor(Long id) {
		return (Contractor) getCurrentSession().get(Contractor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contractor> getAllContractors() {
		return super.getAllEntities(Contractor.class);
	}
	
}
