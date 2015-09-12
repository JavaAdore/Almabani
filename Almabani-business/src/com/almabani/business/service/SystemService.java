package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface SystemService {

	Integer getCountOfSystems(Map<String, Object> filters);

	List<SecSystem> loadSystems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecSystem addSystem(SecSystem SecSystem) throws AlmabaniException;

	SecSystem getSystem(Long id);

	SecSystem updateSystem(SecSystem SecSystem) throws AlmabaniException;
	
	List<SecSystem> getAllSystems();

	List<SecSystem> getAllSystems(Company company);


}
