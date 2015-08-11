package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface ItemDAO extends AbstractDAOInt{

	List<OamItem> loadItems(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);

	Integer getCountOfItems(Map<String, Object> filters);

	OamItem addOrUpdate(OamItem oamItemsQuotSupplier);

	List<OamItem> getAllItems();

	OamItem getItem(Long itemID);


	
	
}
