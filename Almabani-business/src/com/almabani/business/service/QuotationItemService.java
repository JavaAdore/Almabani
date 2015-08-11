package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;

@Service
public interface QuotationItemService {

	Integer getCountOfQoutationItems(Map<String, Object> filters);

	List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean accending, Map<String, Object> filters);

	OamItemQuotation updateQuotationItem(OamItemQuotation oamItemQuotation,
			CommonDriverMap commonDriverMap);

	OamItemQuotation addQuotationItem(OamItemQuotation oamItemQuotation,
			CommonDriverMap commonDriverMap);

	OamItemQuotation getItemQuotation(Long itemQuotationId);

	List<OamItemQuotation> getAllQuotationItems();


	

}
