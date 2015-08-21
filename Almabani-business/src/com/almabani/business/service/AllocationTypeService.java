 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.AllocationType;

@Service
public interface AllocationTypeService {

	List<AllocationType> getAllAllocationTypes();

	AllocationType getAllocationType(Long id);

	List<AllocationType> getAllocationTypes(Company company);
	
}
