package com.almabani.dataaccess.dao.adminoam;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface AllocationTypeDAO extends AbstractDAOInt{

	List<AllocationType> getAllAllocationTypes();

	AllocationType getAllocationType(Long id);
	
}
