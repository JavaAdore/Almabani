package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ManufacturerService {

	Integer getCountOfManufacturers(Map<String, Object> filters);

	List<OamManufacturer> loadManufacturers(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamManufacturer addManufacturer(OamManufacturer manufacturer) throws AlmabaniException;

	OamManufacturer getManufacturer(Long id);

	OamManufacturer updateManufacturer(OamManufacturer manufacturer) throws AlmabaniException;
	
	List<OamManufacturer> getAllManufacturers();


}
