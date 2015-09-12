package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.StockItemService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
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
		Date date = new Date();
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
		Date date = new Date();
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

}
