package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.StockItemService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemDetailsView;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemView;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.StockItemDAO;

@Service
public class StockItemServiceImpl implements StockItemService {

	@Autowired
	private StockItemDAO stockItemDAO;

	@Override
	public Integer getCountOfStockItem(Map<String, Object> filters) {
		return stockItemDAO.getCountOfStockItem(filters);
	}

	@Override
	public List<OamStockItem> loadStockItems(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return stockItemDAO.loadStockItems(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public OamStockItem addStockItem(OamStockItem StockItem,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		StockItem.setLastModificationDate(date);
		StockItem
				.setModificationMakerName(commonDriverMap.getCurrentUserCode());

		return stockItemDAO.addOrUpdateStockItem(StockItem);
	}

	@Override
	public OamStockItem getStockItem(Long id) {
		return stockItemDAO.getStockItem(id);
	}

	@Override
	public OamStockItem updateStockItem(OamStockItem StockItem,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		StockItem.setLastModificationDate(date);
		StockItem
				.setModificationMakerName(commonDriverMap.getCurrentUserCode());

		return stockItemDAO.addOrUpdateStockItem(StockItem);
	}

	@Override
	public List<OamStockItem> getAllStockItems() {
		return stockItemDAO.getAllStockItems();
	}

	@Override
	public List<OamStockItem> getAllStockItems(Company company) {
		return stockItemDAO.getAllStockItems(company);
	}

	@Override
	public List<OamStockItemView> loadOamStockItemsView(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return stockItemDAO.loadOamStockItemsView(first, pageSize, sortField,
				ascending, filters);
	}

	@Override
	public Integer getNumberOfOamStockItemsView(Map<String, Object> filters) {
		return stockItemDAO.getNumberOfOamStockItemsView(filters);
	}

	@Override
	public Integer getNumberOfOamStockItemsDetailsView(
			Map<String, Object> filters) {
		return stockItemDAO.getNumberOfOamStockItemsDetailsView(filters);
	}

	@Override
	public List<OamStockItemDetailsView> loadOamStockItemsDetailsView(
			int first, int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return stockItemDAO.loadOamStockItemsDetailsView(first, pageSize,
				sortField, assending, filters);
	}

	@Override
	public Long getNumberofRemainingItems(OamProjectItem projectItem ,Establishment establishment) {
		return stockItemDAO.getNumberOfRemainingItems(projectItem,establishment);
	}
}



	
