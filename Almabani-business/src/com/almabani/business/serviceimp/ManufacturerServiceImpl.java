package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.business.service.ManufacturerService;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.adminoam.ManufacturerDAO;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	
	@Autowired
	private ManufacturerDAO manufacturerDAO;


	@Override
	public List<OamManufacturer> loadManufacturers(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return manufacturerDAO.loadManufacturers(first,pageSize,sortField,assending,filters);
	}

	@Transactional
	@Override 
	public OamManufacturer addManufacturer(OamManufacturer company) throws AlmabaniException {
		return null;
	}

	@Override
	public OamManufacturer getManufacturer(Long id) {
		return manufacturerDAO.getManufacturer(id);
	}

	@Transactional
	@Override
	public OamManufacturer updateManufacturer(OamManufacturer company) throws AlmabaniException {
	
		return null;
		
		
	}

	@Override
	public Integer getCountOfManufacturers(Map<String, Object> filters) {
		return manufacturerDAO.getCountOfOamManufacturer( filters);
	}

	@Override
	public List<OamManufacturer> getAllManufacturers() {
		return manufacturerDAO.getAllManufacturers();
	}

	
	

}
