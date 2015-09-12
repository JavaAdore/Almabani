package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.business.service.SystemService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataacceess.dao.adminsec.SystemDAO;

@Service
public class SystemServiceImpl implements SystemService {
	
	
	@Autowired
	private SystemDAO systemDAO;


	@Override
	public List<SecSystem> loadSystems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return systemDAO.loadSystems(first,pageSize,sortField,assending,filters);
	}

	@Transactional
	@Override 
	public SecSystem addSystem(SecSystem module) throws AlmabaniException {
		return null;
	}

	@Override
	public SecSystem getSystem(Long id) {
		return systemDAO.getSystem(id);
	}

	@Transactional
	@Override
	public SecSystem updateSystem(SecSystem module) throws AlmabaniException {
	
	
		return null;
		
	}

	@Override
	public Integer getCountOfSystems(Map<String, Object> filters) {
		return systemDAO.getCountOfSystem( filters);
	}

	@Override
	public List<SecSystem> getAllSystems() {
		return systemDAO.getAllSystems();
	}

	@Override
	public List<SecSystem> getAllSystems(Company company) {
		return systemDAO.getAllSystems( company);
	}

	
	

}
