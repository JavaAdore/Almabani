package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface MaterialTypeDAO extends AbstractDAOInt{

	Integer getCountOfMaterialTypes(Map<String, Object> filters);

	List<OamTypeMaterial> loadMaterialTypes(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamTypeMaterial addMaterialType(OamTypeMaterial company);

	OamTypeMaterial getMaterialType(Long id);

	
	List<OamTypeMaterial> getAllMaterialTypes();

	List<OamTypeMaterial> getAllMaterialTypes(Company company);
	
}
