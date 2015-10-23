package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.virtual.entity.StockItemView;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface StockItemDAO extends AbstractDAOInt{

	Integer getCountOfStockItem(Map<String, Object> filters);

	List<OamStockItem> loadStockItems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamStockItem addOrUpdateStockItem(OamStockItem StockItem);

	OamStockItem getStockItem(Long id);

	List<OamStockItem> getAllStockItems();

	List<OamStockItem> getAllStockItems(Company company);

	List<OamStockItem> loadOamStockItemsView(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters);

	Integer getNumberOfOamStockItemsView(Map<String, Object> filters);

	
	
}
