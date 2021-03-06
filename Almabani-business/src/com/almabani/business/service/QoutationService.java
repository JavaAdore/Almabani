package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface QoutationService {

	Integer getCountOfQoutations(Map<String, Object> filters);

	List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	OamQuotation updateQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	OamQuotation addQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap);

	List<OamQuotation> getAllQuotations();

	OamQuotation getQuotataion(Long quotationID);

	List<OamQuotation> getAllQuotations(Company company); 

}
