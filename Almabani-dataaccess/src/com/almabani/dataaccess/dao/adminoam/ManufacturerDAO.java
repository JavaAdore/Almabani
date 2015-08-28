package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ManufacturerDAO extends AbstractDAOInt{

	Integer getCountOfOamManufacturer(Map<String, Object> filters);

	List<OamManufacturer> loadManufacturers(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamManufacturer addOamManufacturer(OamManufacturer manufacturer);

	OamManufacturer getManufacturer(Long id);

	
	List<OamManufacturer> getAllManufacturers();

	List<OamManufacturer> getAllManufacturers(Company company);
	
}
