package com.almabani.dataaccess.dao.admincor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface SupplierDAO extends AbstractDAOInt{

	Integer getCountOfSupplier(Map<String, Object> filters);

	List<OamSupplier> loadSuppliers(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamSupplier addOrUpdateSupplier(OamSupplier supplier);

	OamSupplier getSupplier(Long id);

	List<OamSupplier> getAllSuppliers();


	
}
