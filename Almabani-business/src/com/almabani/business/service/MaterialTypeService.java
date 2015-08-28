package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface MaterialTypeService {

	Integer getCountOfMaterialTypes(Map<String, Object> filters);

	List<OamTypeMaterial> loadMaterialTypes(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamTypeMaterial addMaterialType(OamTypeMaterial company) throws AlmabaniException;

	OamTypeMaterial getMaterialType(Long id);

	OamTypeMaterial updateMaterialType(OamTypeMaterial company) throws AlmabaniException;
	
	List<OamTypeMaterial> getAllMaterialTypes();

	List<OamTypeMaterial> getAllMaterialTypes(Company company);


}
