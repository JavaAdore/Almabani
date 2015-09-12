package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ItemService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public Integer getCountOfItems(Map<String, Object> filters) {

		return itemDAO.getCountOfItems(filters);
	}

	@Override
	public List<OamItem> loadItems(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {

		return itemDAO
				.loadItems(first, pageSize, sortField, ascending, filters);
	}

	@Override
	public OamItem updateItem(OamItem item, CommonDriverMap commonDriverMap) {
		Date date = new Date();
		item.setLastModificationDate(date);
		item.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return itemDAO.addOrUpdate(item);
	}

	@Override
	public OamItem addItem(OamItem item, CommonDriverMap commonDriverMap) {

		Date date = new Date();
		item.setLastModificationDate(date);
		item.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return itemDAO.addOrUpdate(item);
	}

	@Override
	public List<OamItem> getAllItems() {

		return itemDAO.getAllItems();
	}

	@Override
	public OamItem getItem(Long itemID) {

		return itemDAO.getItem(itemID);
	}

	@Override
	public List<OamItem> getAllItems(Company company) {
		return itemDAO.getAllItems(company);
	}

	@Override
	public List<OamItem> getAllItems(String itemNameOrDescription,
			Company company) {
		if (Utils.isNull(company)) {
			return itemDAO.getAllItems(itemNameOrDescription);
		} else {
			return itemDAO.getAllItems(itemNameOrDescription, company);

		}
	}

}
