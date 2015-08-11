package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ItemCategoryDAO extends AbstractDAOInt{

	Integer getCountOfItemCategories(Map<String, Object> filters);

	List<OamItemCategory> loadItemCategories(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamItemCategory addItemCategory(OamItemCategory company);

	OamItemCategory getItemCategory(Long id);

	List<OamItemCategory> getAllItemCategories();
	
}
