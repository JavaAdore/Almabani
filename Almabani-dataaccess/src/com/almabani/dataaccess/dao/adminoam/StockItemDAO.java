package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemDetailsView;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemView;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface StockItemDAO extends AbstractDAOInt{

	Integer getCountOfStockItem(Map<String, Object> filters);

	List<OamStockItem> loadStockItems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamStockItem addOrUpdateStockItem(OamStockItem StockItem);

	OamStockItem getStockItem(Long id);

	List<OamStockItem> getAllStockItems();

	List<OamStockItem> getAllStockItems(Company company);

	List<OamStockItemView> loadOamStockItemsView(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters);

	Integer getNumberOfOamStockItemsView(Map<String, Object> filters);

	List<OamStockItemDetailsView> loadOamStockItemsDetailsView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getNumberOfOamStockItemsDetailsView(Map<String, Object> filters);

	Long getNumberOfRemainingItems(OamProjectItem projectItem,
			OamItemQuotation itemQuotation, Establishment establishment);

	
	
}
