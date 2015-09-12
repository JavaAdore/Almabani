package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ManufacturerService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
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



	@Override
	public OamManufacturer getManufacturer(Long id) {
		return manufacturerDAO.getManufacturer(id);
	}

	
	@Override
	public Integer getCountOfManufacturers(Map<String, Object> filters) {
		return manufacturerDAO.getCountOfOamManufacturer( filters);
	}

	@Override
	public List<OamManufacturer> getAllManufacturers() {
		return manufacturerDAO.getAllManufacturers();
	}

	@Override
	public List<OamManufacturer> getAllManufacturers(Company company) {
		return manufacturerDAO.getAllManufacturers( company);
	}



	@Override
	public OamManufacturer addManufacturer(OamManufacturer manufacturer,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		manufacturer.setLastModificationDate(date);
		manufacturer.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return manufacturerDAO.addOamManufacturer(manufacturer);
	}



	@Override
	public OamManufacturer updateManufacturer(OamManufacturer manufacturer ,CommonDriverMap commonDriverMap)
			throws AlmabaniException {
		Date date = new Date();
		manufacturer.setLastModificationDate(date);
		manufacturer.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return manufacturerDAO.addOamManufacturer(manufacturer);
	}

	
	

}
