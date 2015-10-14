package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.virtual.entity.StockItemView;

@Service
public interface StockItemService {

	Integer getCountOfStockItem(Map<String, Object> filters);

	List<OamStockItem> loadStockItems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	OamStockItem addStockItem(OamStockItem StockItem, CommonDriverMap commonDriverMap) throws AlmabaniException;

	OamStockItem getStockItem(Long id);

	OamStockItem updateStockItem(OamStockItem StockItem, CommonDriverMap commonDriverMap) throws AlmabaniException;

	List<OamStockItem> getAllStockItems();

	List<OamStockItem> getAllStockItems(Company company);

	List<StockItemView> loadOamStockItemsView(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters);

	Integer getNumberOfOamStockItemsView(Map<String, Object> filters);




}
