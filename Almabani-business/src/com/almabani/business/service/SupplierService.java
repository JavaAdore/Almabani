package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface SupplierService {

	Integer getCountOfSupplier(Map<String, Object> filters);

	List<OamSupplier> loadSuppliers(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamSupplier addSupplier(OamSupplier supplier, CommonDriverMap commonDriverMap) throws AlmabaniException;

	OamSupplier getSupplier(Long id);

	OamSupplier updateSupplier(OamSupplier supplier, CommonDriverMap commonDriverMap) throws AlmabaniException;

	List<OamSupplier> getAllSuppliers();

	List<OamSupplier> getAllSuppliers(Company company);

	List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Company company);



}
