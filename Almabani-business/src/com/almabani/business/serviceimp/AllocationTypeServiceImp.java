package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.AllocationTypeService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;

@Service
public class AllocationTypeServiceImp implements AllocationTypeService {
	
	@Autowired
	AllocationTypeDAO allocationTypeDAO;
	
	@Override
	public List<AllocationType> getAllAllocationTypes() {
		return allocationTypeDAO.getAllAllocationTypes();
	}

	@Override
	public AllocationType getAllocationType(Long id) {
		return allocationTypeDAO.getAllocationType(id);
	}

	@Override
	public List<AllocationType> getAllocationTypes(Company company) {
		return allocationTypeDAO.getAllocationTypes(company);
	}

	@Override
	public List<AllocationType> getAllocationType(Project selectedproject) {
		return allocationTypeDAO.getAllocationType(selectedproject);
	}
	
}
