package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItem;

@Service
public interface ItemService {

	Integer getCountOfItems(Map<String, Object> filters);

	List<OamItem> loadItems(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	OamItem updateItem(OamItem oamQuotation,
			CommonDriverMap commonDriverMap);

	OamItem addItem(OamItem oamQuotation,
			CommonDriverMap commonDriverMap);

	List<OamItem> getAllItems();

	OamItem getItem(Long itemID);

	List<OamItem> getAllItems(Company company);

	List<OamItem> getAllItems(String itemNameOrDescription, Company company); 

}
