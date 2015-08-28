package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.business.service.MaterialTypeService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.adminoam.MaterialTypeDAO;
@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {
	  
	
	@Autowired
	private MaterialTypeDAO materialTypeDAO;


	@Override
	public List<OamTypeMaterial> loadMaterialTypes(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return materialTypeDAO.loadMaterialTypes(first, pageSize, sortField, assending, filters);
	}

	@Transactional
	@Override 
	public OamTypeMaterial addMaterialType(OamTypeMaterial materialType) throws AlmabaniException {
		return null;
	}

	@Override
	public OamTypeMaterial getMaterialType(Long id) {
		return materialTypeDAO.getMaterialType(id);
	}

	@Transactional
	@Override
	public OamTypeMaterial updateMaterialType(OamTypeMaterial materialType) throws AlmabaniException {
	
		return materialTypeDAO.addMaterialType(materialType);
		
	}

	@Override
	public Integer getCountOfMaterialTypes(Map<String, Object> filters) {
		return materialTypeDAO.getCountOfMaterialTypes( filters);
	}

	@Override
	public List<OamTypeMaterial> getAllMaterialTypes() {
		return materialTypeDAO.getAllMaterialTypes();
	}

	@Override
	public List<OamTypeMaterial> getAllMaterialTypes(Company company) {
		return materialTypeDAO.getAllMaterialTypes( company);
	}

	
	

}
