package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ItemsQuotSupplierService {

	List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);

	Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters);

	OamItemsQuotSupplier updateOamItemsQuotSupplier(
			OamItemsQuotSupplier oamItemsQuotSupplier,
			CommonDriverMap commonDriverMap);

	OamItemsQuotSupplier addOamItemsQuotSupplier(
			OamItemsQuotSupplier oamItemsQuotSupplier,
			CommonDriverMap commonDriverMap);

	void checkQuotationItemSupplierSelectionAvailability(
			OamItemQuotation oamItemQuotation) throws AlmabaniException;

	void unselectOldSupplierOfQuotationItem(OamItemQuotation itemQuotation);

	

}
