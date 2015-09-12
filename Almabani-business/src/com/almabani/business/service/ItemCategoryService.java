package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ItemCategoryService {

	Integer getCountOfItemCategory(Map<String, Object> filters);

	List<OamItemCategory> loadItemCategories(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamItemCategory addItemCategory(OamItemCategory company) throws AlmabaniException;

	OamItemCategory getItemCategory(Long id);

	OamItemCategory updateItemCategory(OamItemCategory company) throws AlmabaniException;
	
	List<OamItemCategory> getAllItemCategories();

	List<OamItemCategory> getAllItemCategories(Department department);


}
